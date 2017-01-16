package com.rummycircle.wsclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

public final class FileUtils {

    public static final int BYTE_ARRAY_MAX_LENGTH = 2048;

    /**
     * Private Constructor to disable instantiation of the class.
     */
    private FileUtils() {
    }

    /**
     * Returns a FileReader object for the given fileName
     * 
     * @param fileName
     * @return Reader
     * @throws FileNotFoundException
     */
    public static Reader getReader(String fileName) throws FileNotFoundException {
        return getReader(Thread.currentThread().getContextClassLoader().getResource(fileName));
    }

    /**
     * Returns a InputStream object for the given fileName
     * 
     * @param fileName
     * @return InputStream
     * @throws FileNotFoundException
     */
    public static InputStream getInputStream(String fileName) throws FileNotFoundException {
        return getInputStream(Thread.currentThread().getContextClassLoader().getResource(fileName));
    }

    /**
     * Returns a FileReader Object for the given file URL
     * 
     * @param fileURL
     * @return Reader
     * @throws FileNotFoundException
     */
    public static Reader getReader(URL fileURL) throws FileNotFoundException {
        if (fileURL == null)
            throw new FileNotFoundException();
        try {
            return new InputStreamReader(fileURL.openStream());
        } catch (IOException e) {
            throw new FileNotFoundException("Unable to open stream for " + fileURL.getPath());
        }
    }

    /**
     * Returns a InputStream Object for the given file URL
     * 
     * @param fileURL
     * @return InputStream
     * @throws FileNotFoundException
     */
    public static InputStream getInputStream(URL fileURL) throws FileNotFoundException {
        if (fileURL == null)
            throw new FileNotFoundException();
        try {
            return fileURL.openStream();
        } catch (IOException e) {
            throw new FileNotFoundException("Unable to open stream for " + fileURL.getPath());
        }
    }

    /**
     * Returns a Writer Object for the given file name
     * 
     * @param fileName
     * @return Writer
     * @throws FileNotFoundException
     * @throws IOException
     *             if an I/O error occurs.
     */
    public static Writer getWriter(String fileName) throws IOException {
        return getWriter(ClassLoader.getSystemResource(fileName));
    }

    /**
     * Returns a FileWriter Object for the given file URL
     * 
     * @param fileURL
     * @return Writer
     * @throws FileNotFoundException
     * @throws IOException
     *             if an I/O error occurs.
     */
    public static Writer getWriter(URL fileURL) throws IOException {
        if (fileURL == null)
            throw new FileNotFoundException();
        return new FileWriter(new File(fileURL.getPath()));
    }

    /**
     * Writes content to temporary file
     * 
     * @param content
     * @param fileNamePrefix
     * @param suffix
     * @return File object
     * @throws IOException
     *             if an I/O error occurs.
     */
    public static File writeToTempFile(String content, String fileNamePrefix, String suffix)
            throws IOException {
        return writeToTempFile(content.toCharArray(), fileNamePrefix, suffix);
    }

    /**
     * Writes content to temporary file
     * 
     * @param content
     * @param fileNamePrefix
     * @param suffix
     * @return File object
     * @throws IOException
     *             if an I/O error occurs.
     */
    public static File writeToTempFile(char[] content, String fileNamePrefix, String suffix)
            throws IOException {
        File file = File.createTempFile(fileNamePrefix, "." + suffix);
        file.deleteOnExit();
        writeToFile(content, file, false);
        return file;
    }

    /**
     * Writes content to given file name
     * 
     * @param content
     * @param fileName
     * @param append
     * @return File object
     * @throws IOException
     *             if an I/O error occurs.
     */
    public static File writeToFile(String content, String fileName, boolean append) throws IOException {
        File file = new File(fileName);
        writeToFile(content, file, append);
        return file;
    }

    /**
     * Writes content to given file object
     * 
     * @param content
     * @param file
     * @throws IOException
     *             if an I/O error occurs.
     */
    public static void writeToFile(String content, File file, boolean append) throws IOException {
        if (content == null || file == null)
            throw new IllegalArgumentException("Content or File reference cannot be null");
        writeToFile(content.toCharArray(), file, append);
    }

    /**
     * Writes content to given file name
     * 
     * @param content
     * @param fileName
     * @return File object
     * @throws IOException
     *             if an I/O error occurs.
     */
    public static File writeToFile(char[] content, String fileName, boolean append) throws IOException {
        if (fileName == null)
            throw new IllegalArgumentException("File Name cannot be null");
        File file = new File(fileName);
        writeToFile(content, file, append);
        return file;
    }

    /**
     * Writes content to given file object
     * 
     * @param content
     * @param file
     * @throws IOException
     *             if an I/O error occurs.
     */
    public static void writeToFile(char[] content, File file, boolean append) throws IOException {
        if (content == null || file == null)
            throw new IllegalArgumentException("Content or File reference cannot be null");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, append);
            fw.write(content);
            fw.flush();
        } finally {
            if (fw != null)
                fw.close();
        }
    }

    /**
     * Copies data from the reader to the writer Uses a bufferedWriter to
     * optimize the flushing of data Please note that the reader is closed prior
     * to returning However the writer is not closed and its left to the client
     * to close the writer
     * 
     * @param readFrom
     * @param writeTo
     * @throws IOException
     *             if an I/O error occurs.
     * @see Reader#close()
     * @see Writer#close()
     */
    public static void copyStreamContent(Reader readFrom, Writer writeTo) throws IOException {
        BufferedWriter bufWriter = null;
        try {
            bufWriter = new BufferedWriter(writeTo);
            int c;
            while ((c = readFrom.read()) != -1)
                bufWriter.write(c);
            bufWriter.flush();
        } finally {
            readFrom.close();
            if (bufWriter != null)
                bufWriter.close();
        }
    }

    /**
     * Copies data from the reader to the writer Uses a bufferedOutputStream to
     * optimize the flushing of data Please note that the reader is closed prior
     * to returning However the outputStream is not closed and its left to the
     * client to close the outputStream
     * 
     * @param reader
     * @param outputStream
     * @throws IOException
     *             if an I/O error occurs.
     * @see Reader#close()
     * @see OutputStream#close()
     */

    public static void copyStreamContent(Reader reader, OutputStream outputStream) throws IOException {
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(outputStream);
            int c;
            while ((c = reader.read()) != -1)
                bos.write(c);
            bos.flush();
        } finally {
            reader.close();
            if (bos != null) {
                bos.close();
            }
        }
    }

    public static void copyStreamContent(String fromFileName, String toFileName) throws IOException {
        File file = new File(toFileName);
        FileOutputStream fos = new FileOutputStream(file);
        copyStreamContent(getFileInputStream(fromFileName), fos);
        fos.close();
    }

    public static void copyStreamContent(String fromFileName, File file) throws IOException {
        if (file == null)
            throw new IllegalArgumentException("File cannot be null");
        FileOutputStream fos = new FileOutputStream(file);
        copyStreamContent(getFileInputStream(fromFileName), fos);
        fos.close();
    }

    /**
     * Copies data from the inputStream to the file Please note that the
     * inputStream is closed prior to returning
     * 
     * @param is
     * @param file
     * @throws IOException
     *             if an I/O error occurs.
     * @see File
     * @see InputStream
     */
    public static void copyStreamContent(InputStream is, File file) throws IOException {
        if (file == null)
            throw new IllegalArgumentException("File cannot be null");
        FileOutputStream fos = new FileOutputStream(file);
        copyStreamContent(is, fos);
        fos.close();
    }

    /**
     * Copies data from the inputStream to the outputStream Please note that the
     * inputStream is closed prior to returning However the outputStream is not
     * closed and its left to the client to close the outputStream
     * 
     * @param inputStream
     * @param outStream
     * @throws IOException
     *             if an I/O error occurs.
     * @see InputStream
     * @see OutputStream
     */
    public static void copyStreamContent(InputStream inputStream, OutputStream outStream) throws IOException {
        copyStreamContent(inputStream, outStream, BYTE_ARRAY_MAX_LENGTH);
    }

    /**
     * Copies data from the inputStream to the outputStream Please note that the
     * inputStream is closed prior to returning However the outputStream is not
     * closed and its left to the client to close the outputStream
     * 
     * @param inputStream
     * @param outStream
     * @param bufferSize
     * @throws IOException
     *             if an I/O error occurs.
     * @see InputStream
     * @see OutputStream
     */
    public static void copyStreamContent(InputStream inputStream, OutputStream outStream, int bufferSize)
            throws IOException {
        if (inputStream == null || outStream == null)
            throw new IllegalArgumentException("Either the InputStream is null or the output stream is null");
        if (bufferSize <= 0)
            bufferSize = BYTE_ARRAY_MAX_LENGTH;
        BufferedOutputStream bos = new BufferedOutputStream(outStream);
        try {
            byte[] readBytes = new byte[bufferSize];
            int readCount = 0;
            while ((readCount = inputStream.read(readBytes)) != -1) {
                bos.write(readBytes, 0, readCount);
                bos.flush();
            }
        } finally {
            inputStream.close();
            bos.close();
        }
    }

    /**
     * Returns byte array of content of a file
     * 
     * @param content
     *            file object
     * @return byte array
     * @throws IOException
     *             if an I/O error occurs.
     */
    public static byte[] getBytes(File content) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        copyStreamContent(new FileInputStream(content), baos, BYTE_ARRAY_MAX_LENGTH);
        return baos.toByteArray();

    }

    /**
     * Convenient method to find the extension of a file given the file object.
     * It returns an empty string in case the file name doesnot have an
     * extension
     * 
     * @see StringUtils#EMPTY_STRING
     * @param file
     * @return The string after the last occurrence of a . in the file name.
     *         Otherwise an empty string.
     * @see StringUtils#EMPTY_STRING
     */
    public static String getFileExtension(File file) {
        if (file == null)
            throw new IllegalArgumentException("The file passed is null");
        return getFileExtension(file.getName());
    }

    /**
     * Convenient method to find the extension of a file given the file name. It
     * returns an empty string in case the file name doesnot have an extension
     * 
     * @see StringUtils#EMPTY_STRING
     * @param fileName
     * @return The string after the last occurrence of a . in the file name.
     *         Otherwise an empty string.
     * @see StringUtils#EMPTY_STRING
     */
    public static String getFileExtension(String fileName) {
        if (!StringUtils.isEmpty(fileName)) {
            int i = fileName.lastIndexOf(".");

            if (i > 0) {
                return (fileName.substring(i + 1));
            }
        }
        // In case file doesnt have any extension
        return StringUtils.EMPTY_STRING;
    }

    /**
     * Reads the contents of a file and returns it as string. Tries to read
     * directly, or from the relative classpath.
     * 
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String readFileAsString(String fileName) throws IOException {
        File fileToread = new File(fileName);
        BufferedReader reader = null;
        StringBuilder contents = new StringBuilder();
        if (fileToread.exists()) {
            reader = new BufferedReader(new FileReader(fileToread));
        } else {
            reader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(fileName)));
        }
        char[] buf = new char[BYTE_ARRAY_MAX_LENGTH];
        int length = 0;
        while ((length = reader.read(buf)) != -1) {
            contents.append(buf, 0, length);
        }
        reader.close();
        return contents.toString();
    }

    public static OutputStream getFileOutputStream(String fileName, boolean append) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName, append));
        return bos;
    }

    public static Writer getFileWriter(String fileName, boolean append) throws IOException {
        Writer w = new BufferedWriter(new FileWriter(fileName, append));
        return w;
    }

    public static InputStream getFileInputStream(String fileName) throws IOException {
        BufferedInputStream bos = new BufferedInputStream(new FileInputStream(fileName));
        return bos;
    }

    public static Reader getFileReader(String fileName) throws IOException {
        Reader reader = new BufferedReader(new FileReader(fileName));
        return reader;
    }

    public static void deleteDirectory(String dirName) throws IOException {
        File dir = new File(dirName);
        deleteDirectory(dir);
    }

    public static void deleteDirectory(File dir) throws IOException {
        if (!dir.exists())
            return;

        File[] files = dir.listFiles();
        for (File file : files) {
            deleteFile(file);
        }
        deleteFile(dir);
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        deleteFile(file);
    }

    public static void deleteFile(File file) {
        System.gc();
        boolean deletedSuccessfully = false;
        if (file.exists())
            deletedSuccessfully = file.delete();
        if (!deletedSuccessfully) {
            file.renameTo(new File(file.getAbsoluteFile() + file.getName() + "_todelete"));
        }
    }
}
