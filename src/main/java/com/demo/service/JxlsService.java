package com.demo.service;

import com.demo.dto.Employee;
import lombok.SneakyThrows;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class JxlsService {


    @SneakyThrows
    public void write(OutputStream outputStream) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee source = new Employee();
            source.setNo(Integer.toString(i));
            source.setName(String.format("tester%s", i));
            source.setTitle(String.format("testTitle%s", i));
            employees.add(source);
        }
        var loader = Thread.currentThread().getContextClassLoader();
        try (InputStream is =
                     loader.getResourceAsStream("templates/simple-demo.xlsx")) {
            Context context = new Context();
            context.putVar("employees", employees);
            JxlsHelper.getInstance().processTemplate(is, outputStream, context);
        }

    }
}
