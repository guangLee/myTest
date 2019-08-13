package com.datastructure.queue;

/**
 * 环形队列的下标移动，是挺有逻辑思维含量的
 * 需要动脑筋好好想一下它的运转，最好在纸上一步一步模拟，哈哈
 * 取余 是为了 数组的下标值 始终都小于 数组的size
 */
public class CircleArrayQueue {

    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     *front指向队列的第一个元素，也就是说 arr[front] 就是队列的第一个元素
     *front 的初始值 = 0
     */
    private int front;
    /**
     * 队列尾 rear 指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
     * rear的初始值 = 0
     */
    private int rear;
    /**
     *该数据用于存放数据, 模拟队列
     */
    private int[] array;

    public CircleArrayQueue(int arraySize){
        maxSize = arraySize;
        array = new int[maxSize];
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return (rear  + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     * @param n
     */
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        //直接将数据加入
        array[rear] = n;
        //将 rear 后移, 这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列的数据, 出队列
     * @return
     */
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        // 这里需要分析出 front是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = array[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 求出当前队列有效数据的个数
     * @return
     */
    public int size() {
        //这一块儿逻辑挺绕的，随着环形的转动，会出现这种情况： 头front的值是6，尾rear的值是 5，
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        // 动脑筋  如果不取余，数组下标会越界
        for (int i = front; i < front + size() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, array[i % maxSize]);
        }
    }

    /**
     * 显示队列的头数据， 注意不是取出数据
     * @return
     */
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return array[front];
    }

}
