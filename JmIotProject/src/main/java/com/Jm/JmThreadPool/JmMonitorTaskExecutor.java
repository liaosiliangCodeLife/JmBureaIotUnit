package com.Jm.JmThreadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/28 下午4:54
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
public class JmMonitorTaskExecutor extends ThreadPoolTaskExecutor {

    private static final Logger taskLogger = LoggerFactory.getLogger(JmMonitorTaskExecutor.class);

    private void showJmThreadPoolInfo(String prefix){
        ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();

        if(null==threadPoolExecutor){
            return;
        }

        taskLogger.info("{}, {},taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                this.getThreadNamePrefix(),
                prefix,
                threadPoolExecutor.getTaskCount(),
                threadPoolExecutor.getCompletedTaskCount(),
                threadPoolExecutor.getActiveCount(),
                threadPoolExecutor.getQueue().size());
    }

    @Override
    public void execute(Runnable task) {
        showJmThreadPoolInfo("WithOut TimeOut Execute");
        super.execute(task);
    }

    @Override
    public void execute(Runnable task, long startTimeout) {
        showJmThreadPoolInfo("With TimeOut "+ startTimeout + "Execute");
        super.execute(task, startTimeout);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        showJmThreadPoolInfo("Submit Task With Callable");
        return super.submit(task);
    }

    @Override
    public Future<?> submit(Runnable task) {
        showJmThreadPoolInfo("Submit Task With Runnable");
        return super.submit(task);
    }

    @Override
    public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
        showJmThreadPoolInfo("SubmitListenable Task With Callable");
        return super.submitListenable(task);
    }

    @Override
    public ListenableFuture<?> submitListenable(Runnable task) {
        showJmThreadPoolInfo("SubmitListenable Task With Runnable");
        return super.submitListenable(task);
    }
}
