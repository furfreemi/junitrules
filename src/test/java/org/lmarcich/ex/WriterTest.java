package org.lmarcich.ex;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WriterTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void testDemo() throws IOException {
        String filename = "test_file";
        String expectedString = "yayyyy test string";

        temporaryFolder.newFile(filename);

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(expectedString);
        writer.close();

        assertThat(new BufferedReader(new FileReader(filename)).readLine(), is(expectedString));
    }
}
