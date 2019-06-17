package com.fork;

import java.util.concurrent.RecursiveTask;

public class ForkJoinWork extends RecursiveTask<Long> {

    //起始值
    private Long start;
    //结束值
    private Long end;
    //临界值
    public static final  Long critical = 100000L;

    public ForkJoinWork(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        //判断是否是拆分完毕
        Long lenth = end - start;
        if(lenth<=critical){
            //如果拆分完毕就相加
            Long sum = 0L;
            for (Long i = start;i<=end;i++){
                sum += i;
            }
            return sum;
        }else {
            //没有拆分完毕就开始拆分,计算的两个值的中间值
            Long middle = (end + start)/2;

            ForkJoinWork right = new ForkJoinWork(start,middle);
            //拆分，并压入线程队列
            right.fork();
            ForkJoinWork left = new ForkJoinWork(middle+1,end);
            //拆分，并压入线程队列
            left.fork();
            //合并
            return right.join() + left.join();
        }
    }
}
