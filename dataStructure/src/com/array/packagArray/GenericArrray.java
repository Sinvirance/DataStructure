package com.array.packagArray;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/9 22:13
 * @Description: 对我们自己封装的数组Array 实现泛型
 */

public class GenericArrray<E> {

    private E[] data;
    private int size;

    /**
     * 有参构造函数,传入数组容量 Capacity 构造 Array
     * @param Capacity 数组容量E
     */
    public GenericArrray(int Capacity) {
        // 实现泛型的构造函数需要将Object 类型的强转
        data = (E[])new Object[Capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认数组容量Capacity
     */
    public GenericArrray() {
        this(10);
    }


    /**
     * 获取数组中的元素个数
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     * @return date.length
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在 index 位置插入新的元素 e, 原理是从最后一个元素开始到index位置的元素全部往后移动，再在index位置插入e
     * @param index 插入元素的索引位置
     * @param e 插入的元素
     */
    public void add(int index, E e) {

        if (size == data.length) {
            try {
                throw new IllegalArgumentException("Add failed, Array is full");
            } catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
            }
        }

        if (index < 0 || index > size) {
            try {
                throw new IllegalArgumentException("Add failed, Require index >= 0 and index < size");
            } catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
            }
        }
        // 索引 index 之后的元素每一位向后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 在所有元素前添加一个新元素
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在所有元素的最后后添加一个新元素
     * @param e 添加的元素
     */
    public void addLast(E e) {
        /*
        if (size == data.length) {
            try {
                throw new IllegalArgumentException("AddLast failed, Array is full");
            } catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
            }
        }
        data[size] = e;
        size ++;
        */
        add(size, e);
    }


    /**
     * 获取index 索引位置的元素
     * @param index 索引下标
     * @return data[index]
     */
    E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Index is illegl");
        return data[index];
    }

    /**
     * 修改 index 索引位置的元素为 e
     * @param index 索引下标
     * @param e 修改后的元素
     */
    void set(int index, E e) {
        data[index] = e;
    }

    /**
     * 查找数组 是否包含元素e
     * @param e 包含的元素
     * @return 有返回ture， 无返回 false
     */
    public boolean contain(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引
     * @param e 查找的元素e
     * @return 存在返回元素的下标，不存在e，返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 删除数组指定位置的元素
     * @param index 指定位置的下标
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index <  0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, Index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        // 将索引所指向的对象引用设置为空
        data[size] = null;
        return ret;
    }

    /**
     * 从数组中删除第一个元素
     * @return 删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     * @return 删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 查找元素有就删除
     * @param e 查找的元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != 1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
