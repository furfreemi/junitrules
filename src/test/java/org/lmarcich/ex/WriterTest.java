package org.lmarcich.ex;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WriterTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void testDemo() throws IOException {
        String filename = "test_file";
        String expectedString = "yayyyy test string";

        File tempFile = temporaryFolder.newFile(filename);

        Files.write(tempFile.toPath(), Arrays.asList(expectedString), StandardOpenOption.WRITE);

        List<String> records = Files.readAllLines(tempFile.toPath(), Charset.defaultCharset());

        assertThat(records.get(0), is(expectedString));
        assertThat(records.size(), is(1));
    }
}
