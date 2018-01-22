package com.soecode.lyf.service.impl;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by llh on 2018-01-19 17:25
 */
public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception {
        long bookId = 1001;
        long studentId = 12345678910L;
        try {
            AppointExecution execution = bookService.appoint(bookId, studentId);
            System.out.println(execution);
        } catch (Exception e) {
            System.out.println("========");
        }
    }
}
