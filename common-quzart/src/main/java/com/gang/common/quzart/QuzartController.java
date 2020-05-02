package com.gang.common.quzart;

import com.gang.common.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname QuzartController
 * @Description TODO
 * @Date 2020/4/28 20:30
 * @Created by zengzg
 */
@RestController
@RequestMapping(value = "/common/task")
public class QuzartController {


    @Autowired
    private QuzartService taskService;

    @PostMapping(value = "/add")
    public ResponseEntity addTask(@RequestBody TaskEntity taskEntity) {
        return taskService.addTask(taskEntity) ? new ResponseEntity(HttpStatus.OK) :
                new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/update")
    public ResponseEntity updateTask(@RequestBody TaskEntity taskEntity) {
        return taskService.updateTask(taskEntity) ? new ResponseEntity(HttpStatus.OK) :
                new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/queryJob")
    public ResponseEntity queryJob(TaskEntity taskEntity) {
        List<TaskEntity> taskEntities = taskService.findTaskList(taskEntity);
        return taskEntities.size() == 0 ? new ResponseEntity("Not Exist!", HttpStatus.OK) :
                new ResponseEntity(taskEntities, HttpStatus.OK);
    }


    @PostMapping(value = "/delete")
    public ResponseEntity deleteTask(@RequestBody TaskEntity taskEntity) {
        boolean flag = taskService.deleteTask(taskEntity);
        return flag ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    @PostMapping(value = "/pause")
    public ResponseEntity pauseTask(@RequestBody TaskEntity taskEntity) {
        boolean flag = taskService.pauseTask(taskEntity);
        return flag ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    @PostMapping(value = "/resume")
    public ResponseEntity resumeTask(@RequestBody TaskEntity taskEntity) {
        boolean flag = taskService.resumeTask(taskEntity);
        return flag ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
