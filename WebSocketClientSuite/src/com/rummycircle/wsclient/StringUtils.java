package com.rummycircle.wsclient;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

public class StringUtils {

    public static final String EMPTY_STRING = "";

    protected StringUtils() {
    }

    /**
     * Checks whether a given String has a valid content or not. Empty spaces
     * are not treated as a valid content for a String.
     * 
     * @param str
     * @return true if the string is null or empty spaces.
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.trim().equals(""));
    }

    /**
     * Tokenises a String based on a delimiter and returns the tokens in an
     * Array.
     * 
     * @param string
     * @param token
     * @return String Array
     */
    public static String[] toStringArray(String string, String token) {
        if (string == null || token == null)
            throw new IllegalArgumentException("String / Delimiter cannot be null");
        StringTokenizer tokenizer = new StringTokenizer(string, token);
        String[] stringArray = new String[tokenizer.countTokens()];
        int count = 0;
        while (tokenizer.hasMoreElements()) {
            stringArray[count++] = tokenizer.nextToken();
        }
        return stringArray;
    }

    /**
     * Tokenises a String based on the default delimiter(',') and returns the
     * tokens in an Array.
     * 
     * @param string
     * @return String Array
     */
    public static String[] toStringArray(String string) {
        return toStringArray(string, ",");
    }

    /**
     * Converts a String to a char messageType The length of the String must not
     * be greates that one.
     * 
     * @param string
     * @return character
     */
    public static char toChar(String string) {
        if (string == null || string.length() != 1)
            throw new IllegalArgumentException("String needs to have a single character");
        return string.charAt(0);
    }

    /**
     * Converts a char to a String
     * 
     * @param c
     *            char
     * @return string
     */
    public static String toString(char c) {
        return new String(new char[] { c });
    }

    /**
     * Converts target string to uppercase
     * 
     * @param target
     * @return converted string
     */
    public static String capitalize(String target) {
        if (isEmpty(target))
            return null;
        return Character.toUpperCase(target.charAt(0)) + target.substring(1);
    }

    /**
     * @param regex
     * @param targetString
     * @return The result of String.split(regex) except that Trailing empty
     *         strings are included in the resulting array
     */
    public static String[] split(String regex, String targetString) {
        if (targetString != null) {
            if (targetString.endsWith(regex)) {
                if (!regex.equals("1"))
                    targetString += "1";
                else
                    targetString += "2";
                String[] result = targetString.split(regex);
                result[result.length - 1] = "";
                return result;
            } else {
                return targetString.split(regex);
            }
        } else {
            return null;
        }
    }

    /**
     * Returns a String with newline added between the content e.g.: if the
     * content is content={"Hi There, ", "I'm fine", "Thanks,"}, the returned
     * String would be:
     * 
     * <pre>
     * Hi There,
     * I'm fine
     * Thanks,
     * </pre>
     * 
     * @param content
     *            chunks of text that need to be separated by newline
     * @return result string
     */
    public static String formatTextWithNewLine(String[] content) {
        try {
            StringWriter sw = new StringWriter();
            BufferedWriter bf = new BufferedWriter(sw);
            for (int i = 0; i < content.length; i++) {
                bf.write(content[i]);
                bf.newLine();
            }
            bf.close();
            String formattedText = sw.getBuffer().toString();
            return formattedText;
        } catch (IOException ioe) {
            return EMPTY_STRING;
        }
    }

    /**
     * Concatenates individual strings in the array, separated by the delimiter
     * string each time.
     * 
     * @param array
     * @param delimiter
     * @return result string
     */
    public static String toDelimiterSeparatedString(String[] array, String delimiter) {
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (!isEmpty(array[i])) {
                expression.append(array[i]);
                expression.append(delimiter);
            }
        }
        // Delete the extra "'" character at the end
        if (expression.length() > 2)
            expression.deleteCharAt(expression.length() - 1);
        return expression.toString();
    }

    /**
     * Checks whether a string has digits
     * 
     * @param s
     * @return true if s contains at least 1 digit
     */
    public static boolean hasDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                return true;
        }
        return false;
    }

    public static HashMap<String, String> stringToPropsMap(String propsStr) throws IOException {
        if (propsStr == null)
            return new HashMap<String, String>();
        Properties props = new Properties();
        ByteArrayInputStream bais = null;
        bais = new ByteArrayInputStream(propsStr.getBytes());
        props.load(bais);
        HashMap<String, String> map = new HashMap<String, String>();
        Enumeration<Object> en = props.keys();
        String key, value;
        while (en.hasMoreElements()) {
            key = (String) en.nextElement();
            value = props.getProperty(key);
            map.put(key, value);
        }
        return map;
    }

    public static String propsMapToStr(Map<String, Object> props) {
        if (props == null || props.isEmpty())
            return "";
        Iterator<Map.Entry<String, Object>> itr = props.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (itr.hasNext()) {
            Map.Entry<String, Object> entry = itr.next();
            sb.append(entry.getKey());
            sb.append("=");
            Object val = entry.getValue();
            sb.append(val != null ? val.toString() : "null");
            sb.append("\n");
        }
        return sb.toString();
    }

}
