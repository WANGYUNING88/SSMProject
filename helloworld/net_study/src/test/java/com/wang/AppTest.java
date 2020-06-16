package com.wang;

import static org.junit.Assert.assertTrue;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @SneakyThrows
    @Test
    public void shouldAnswerWithTrue()
    {
        File file = new File("");
        String filePath = file.getCanonicalPath();
        System.out.println(filePath);

        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
    }
}
