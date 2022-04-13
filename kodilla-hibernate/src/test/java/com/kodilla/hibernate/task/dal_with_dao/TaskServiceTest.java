package com.kodilla.hibernate.task.dal_with_dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskFinancialDetailsDao;
import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.dao.TaskListDao;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureDataJpa
class TaskServiceTest {

    @Autowired
    private TaskFinancialDetailsDao taskFinancialDetailsDao;

    @Autowired
    private TaskListDao taskListDao;

    @Autowired
    private com.kodilla.hibernate.task.dao.TaskDao taskDao;

    private final static TaskService taskService = new TaskService();

    private final static Logger log = LoggerFactory.getLogger(TaskServiceTest.class);

    @Test
    void persist() throws IOException {
        //Given
        Task task = new Task("testingPureDao", 1);

        //When
        taskService.persist(task);

        //Then
        taskService.getTaskDao().openCurrentSession();
        Query<Task> query = taskService.getTaskDao().getCurrentSession().createQuery("from Task WHERE duration = 1");
        assertEquals(1, query.getResultList().size());
        taskService.getTaskDao().closeCurrentSession();

        //CleanUp
        try {
            taskService.getTaskDao().openCurrentSessionWithTransaction();
            String hql = "delete from Task where duration = 1";
            Query<Task> queryForClean = taskService.getTaskDao().getCurrentSession().createQuery(hql);
            queryForClean.executeUpdate();
            taskService.getTaskDao().closeCurrentSessionWithTransaction();
        } catch (JDBCException e) {
            log.warn(e.getSQL());
        }
    }

    @Test
    void update() {
        //Given
        String hql = "from Task where id = 520";
        try {
            taskService.getTaskDao().openCurrentSessionWithTransaction();
            Query query = taskService.getTaskDao().getCurrentSession().createQuery(hql);
            Task task = (Task) query.uniqueResult();
            task.setDescription("Testing HibernateDao117");
            taskService.getTaskDao().closeCurrentSessionWithTransaction();

            //When
            try {
                taskService.getTaskDao().openCurrentSessionWithTransaction();
                taskService.update(task);
            } catch (IOException e) {
                log.warn(e.getMessage());
            }
        } catch (IOException e) {
            log.warn(e.getMessage());
        }

        //Then
        try {
            ResultSet rs = JDBC_Query("SELECT description FROM kodilla_course.tasks t WHERE id = 520", 0, 0);
            assertEquals("Testing HibernateDao117", rs.getString("description"));
            rs.close();
        } catch (SQLException e) {
            log.warn(e.getSQLState());
        }

        //CleanUp
        try {
            ResultSet rs = JDBC_Query("SELECT description FROM kodilla_course.tasks t WHERE description = 'Testing HibernateDao117'", 0,0);
//            Task task = rs.getString()
        } catch (SQLException e) {
            log.info("Cleaning update test failed..." + " INFO: " + e.getSQLState());
        }
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void getTaskDao() {
    }

    @Test
    public void testJDBC_QueryMethod() throws SQLException {
        //Given
        String sqlQuery = "SELECT * FROM kodilla_course.tasks";

        //When
        ResultSet rs = JDBC_Query(sqlQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, 0);

        //Then
        rs.last();
        assertEquals(5, rs.getRow());
        rs.close();
    }

    @Test
    public void testTaskFinancialDetails_ID_mapper() {
        //Given
        int id = 521;

        //When
        try {
            TaskFinancialDetails result = mapTaskFinancialDetailsId_to_TaskFinancialDetails(id).get();

            //Then
            assertEquals(taskFinancialDetailsDao.findById(521).get().getPrice(), result.getPrice());
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }

    @Test
    public void testTaskList_ID_mapper() {
        //Given
        TaskList taskList = new TaskList("LearningJavaWebStuff", "You are getting better & better!");
        List<Task> tasksWith_30_Duration = new ArrayList<>(taskDao.findByDuration(30));
        taskList.getTasks().addAll(tasksWith_30_Duration);
        for (Task task : tasksWith_30_Duration) {
            task.setTaskList(taskList);
        }
        try {
            taskListDao.save(taskList);
            taskDao.saveAll(tasksWith_30_Duration);
        } catch (HibernateException e) {
            log.warn(e.getMessage());
        }

        int id = taskListDao.findByListName("LearningJavaWebStuff").get(0).getId();

        //When
        try {
            Optional<TaskList> result = mapTaskListId_to_TaskList(id);

            //Then
            assertEquals("LearningJavaWebStuff", result.get().getListName());
        } catch (Exception e) {
            log.warn(e.getMessage());
        }

        //CleanUp
        /** please implement CleanUp here!
        try {
            //some cleanUp impl.
        } catch (SQLException e) {
            log.warn(e.getSQLState());
        } */
    }

    @Test
    public void testMapTaskDaoToTask() throws Exception {
        //Given
        String selectQuery = "SELECT * FROM kodilla_course.tasks WHERE id = 520";

        //When
        var taskFromDb = mapTaskDaoToTask(selectQuery);
        System.out.println(taskFromDb);

        //Then
        var TFD_dao_result = taskFinancialDetailsDao.findById(521);
        var TL_dao_result = taskListDao.findById(862);

        assertEquals(520, taskFromDb.getId());
        assertEquals("Testing HibernateDao117", taskFromDb.getDescription());
        assertEquals(30, taskFromDb.getDuration());
        assertEquals(TFD_dao_result.get().getPrice(), taskFromDb.getTaskFinancialDetails().getPrice());
        assertEquals(TL_dao_result.get().getDescription(), taskFromDb.getTaskList().getDescription());
    }


    //METHODS (MOVE IT TO ANOTHER PACKAGE!)
    /** Method to execute JDBC_Query **/
    public static ResultSet JDBC_Query(String sqlQuery, int resultSet_Type, int resultSet_Concurrency) throws SQLException {
        if (resultSet_Type == 0) {
            resultSet_Type = ResultSet.TYPE_FORWARD_ONLY;
        } else if (resultSet_Concurrency == 0) {
            resultSet_Concurrency = ResultSet.CONCUR_UPDATABLE;
        }
        Statement statement;
        Connection connection = DbManager.getInstance().getConnection();
        statement = connection.createStatement(resultSet_Type, resultSet_Concurrency);
        statement.executeQuery(sqlQuery);
        return statement.getResultSet();
    }

    /** Method to map from TFD_id -> TFD (needed for JDBC) **/
    public Optional<TaskFinancialDetails> mapTaskFinancialDetailsId_to_TaskFinancialDetails(int taskFinancialDetails_id) throws Exception {
        if (taskFinancialDetails_id == 0) {
            throw new Exception("Given ID cannot be 0!");
        }
        return taskFinancialDetailsDao.findById(taskFinancialDetails_id);
    }

    /** Method to map from TL_id -> TL (needed for JDBC) **/
    public Optional<TaskList> mapTaskListId_to_TaskList(int taskList_id) throws Exception {
        if (taskList_id == 0) {
            throw new Exception("Given ID cannot be 0!");
        }
        return taskListDao.findById(taskList_id);
    }

    /** Method to map from TaskDao -> Task (using JDBC) **/
    public Task mapTaskDaoToTask(String selectQuery) throws Exception {
        if (selectQuery.isEmpty()) {
            throw new Exception("Please inject NOT EMPTY query!");
        }
        try {
            Statement statement;
            Connection connection = DbManager.getInstance().getConnection();
            statement = connection.createStatement();
            statement.executeQuery(selectQuery);
            ResultSet rs = statement.getResultSet();
            rs.next();

            Task task = Task.builder()
                    .id(Integer.parseInt(rs.getString("id")))
                    .created(rs.getDate("created"))
                    .description(rs.getString("description"))
                    .duration(Integer.parseInt(rs.getString("duration")))
                    .taskFinancialDetails(this.mapTaskFinancialDetailsId_to_TaskFinancialDetails(Integer.parseInt(rs.getString("tasks_financials_id"))).get())
                    .taskList(this.mapTaskListId_to_TaskList(Integer.parseInt(rs.getString("tasklist_id"))).get())
                    .build();

            rs.close();
            return task;
        } catch (SQLException e) {
            log.error("Wrong query (not SELECT type) or internal code bug...");
            System.out.println(e.getSQLState() + " \n EXCEPTION message here -> " + e.getMessage() + "\n STACK_TRACE here -> " + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }
}