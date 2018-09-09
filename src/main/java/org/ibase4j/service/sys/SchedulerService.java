package org.ibase4j.service.sys;

import java.util.Date;
import java.util.Map;

import org.ibase4j.core.support.Assert;
import org.ibase4j.core.support.scheduler.manager.SchedulerManager;
import org.ibase4j.core.util.InstanceUtil;
import org.ibase4j.dao.generator.TaskFireLogMapper;
import org.ibase4j.dao.generator.TaskGroupMapper;
import org.ibase4j.dao.generator.TaskSchedulerMapper;
import org.ibase4j.dao.scheduler.TaskSchedulerExpandMapper;
import org.ibase4j.model.generator.TaskFireLog;
import org.ibase4j.model.generator.TaskGroup;
import org.ibase4j.model.generator.TaskScheduler;
import org.ibase4j.model.scheduler.TaskScheduled;
import org.ibase4j.model.scheduler.TaskSchedulerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年7月1日 上午11:34:59
 */
//@Service
public class SchedulerService {
    @Autowired
    private TaskSchedulerExpandMapper expandMapper;
    @Autowired
    private TaskGroupMapper taskGroupMapper;
    @Autowired
    private TaskSchedulerMapper taskSchedulerMapper;
    @Autowired
    private TaskFireLogMapper logMapper;
    @Autowired
    private SchedulerManager schedulerManager;

    @Cacheable("taskGroup")
    public TaskGroup getGroupById(Integer id) {
        return taskGroupMapper.selectByPrimaryKey(id);
    }

    @Cacheable("taskScheduler")
    public TaskScheduler getSchedulerById(Integer id) {
        return taskSchedulerMapper.selectByPrimaryKey(id);
    }

    @Cacheable("taskFireLog")
    public TaskFireLog getFireLogById(Integer id) {
        return logMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @CachePut("taskGroup")
    public TaskGroup updateGroup(TaskGroup record) {
        record.setEnable(true);
        if (record.getId() == null) {
            record.setCreateTime(new Date());
            taskGroupMapper.insert(record);
        } else {
            record.setUpdateTime(new Date());
            taskGroupMapper.updateByPrimaryKey(record);
        }
        return record;
    }

    @Transactional
    @CachePut("taskScheduler")
    public TaskScheduler updateScheduler(TaskScheduler record) {
        record.setEnable(true);
        if (record.getId() == null) {
            record.setCreateTime(new Date());
            taskSchedulerMapper.insert(record);
        } else {
            record.setUpdateTime(new Date());
            taskSchedulerMapper.updateByPrimaryKey(record);
        }
        return record;
    }

    @Transactional
    @CachePut("taskFireLog")
    public TaskFireLog updateLog(TaskFireLog record) {
        if (record.getId() == null) {
            logMapper.insert(record);
        } else {
            logMapper.updateByPrimaryKey(record);
        }
        return record;
    }

    public PageInfo<TaskGroup> queryGroup(Map<String, Object> params) {
        Page<Integer> ids = expandMapper.queryGroup(params);
        Page<TaskGroup> page = new Page<TaskGroup>(ids.getPageNum(), ids.getPageSize());
        page.setTotal(ids.getTotal());
        if (ids != null) {
            page.clear();
            for (Integer id : ids) {
                page.add(InstanceUtil.getBean(getClass()).getGroupById(id));
            }
        }
        return new PageInfo<TaskGroup>(page);
    }

    public PageInfo<TaskSchedulerBean> queryScheduler(Map<String, Object> params) {
        Page<Integer> ids = expandMapper.queryScheduler(params);
        Page<TaskSchedulerBean> page = new Page<TaskSchedulerBean>(ids.getPageNum(), ids.getPageSize());
        page.setTotal(ids.getTotal());
        if (ids != null) {
            page.clear();
            for (Integer id : ids) {
                TaskScheduler taskScheduler = InstanceUtil.getBean(getClass()).getSchedulerById(id);
                TaskSchedulerBean bean = InstanceUtil.to(taskScheduler, TaskSchedulerBean.class);
                TaskGroup taskGroup = InstanceUtil.getBean(getClass()).getGroupById(bean.getGroupId());
                bean.setGroupName(taskGroup.getGroupName());
                bean.setTaskDesc(taskGroup.getGroupDesc() + ":" + bean.getTaskDesc());
                page.add(bean);
            }
        }
        return new PageInfo<TaskSchedulerBean>(page);
    }

    public PageInfo<TaskFireLog> queryLog(Map<String, Object> params) {
        Page<Integer> ids = expandMapper.queryLog(params);
        Page<TaskFireLog> page = new Page<TaskFireLog>(ids.getPageNum(), ids.getPageSize());
        page.setTotal(ids.getTotal());
        if (ids != null) {
            page.clear();
            for (Integer id : ids) {
                page.add(InstanceUtil.getBean(getClass()).getFireLogById(id));
            }
        }
        return new PageInfo<TaskFireLog>(page);
    }

    // 获取所有作业
    public PageInfo<TaskScheduled> getAllJobDetail() {
        PageInfo<TaskScheduled> pageInfo = new PageInfo<TaskScheduled>();
        pageInfo.setList(schedulerManager.getAllJobDetail());
        pageInfo.setPages(1);
        pageInfo.setSize(pageInfo.getList().size());
        return pageInfo;
    }

    // 执行作业
    public boolean execTask(String taskGroup, String taskName) {
        Assert.notNull(taskGroup, "TASKGROUP");
        Assert.notNull(taskName, "TASKNAME");
        TaskScheduled taskScheduler = new TaskScheduled();
        taskScheduler.setTaskGroup(taskGroup);
        taskScheduler.setTaskName(taskName);
        return schedulerManager.runJob(taskScheduler);
    }

    // 暂停/恢复作业
    public boolean openCloseTask(String taskGroup, String taskName, String status) {
        Assert.notNull(taskGroup, "TASKGROUP");
        Assert.notNull(taskName, "TASKNAME");
        TaskScheduled taskScheduler = new TaskScheduled();
        taskScheduler.setTaskGroup(taskGroup);
        taskScheduler.setTaskName(taskName);
        if ("start".equals(status)) {
            return schedulerManager.resumeJob(taskScheduler);
        } else if ("stop".equals(status)) {
            return schedulerManager.stopJob(taskScheduler);
        }
        return false;
    }
}
