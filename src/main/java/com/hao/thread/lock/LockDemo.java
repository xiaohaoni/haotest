package com.hao.thread.lock;

import sun.misc.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁&&非公平锁
 *
 * @author zrh
 * @version 1.0
 * @date 2021-02-26 22:19
 **/
public class LockDemo {


    /* private static void reentryReentrantLock() {
         Lock lock = new ReentrantLock();
         try {
             lock.lock();
             System.out.println("reentry1");
             reentryReentrantLock1();
         } catch (Exception e) {
             System.out.println(e.getMessage());
         } finally {
             lock.unlock();
         }

     }

     private static void reentryReentrantLock1() {
         Lock lock = new ReentrantLock();
         try {
             lock.lock();
             System.out.println("reentry2");
         } catch (Exception e) {
             System.out.println(e.getMessage());
         } finally {
             lock.unlock();
         }

     }*/
    static Lock lock = new Lock();

    private static void reentryLock() {
        try {
            lock.lock();
            System.out.println("reentry1");
            reentryLock1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }

    }

    private static void reentryLock1() {
        Lock lock = new Lock();
        try {
            lock.lock();
            System.out.println("reentry2");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        reentryLock();
    }

}
