/**
 * Created by shibayu36 on 2016/12/17.
 */

package org.shibayu36.intern.exercise;

import java.util.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.shibayu36.intern.exercise.exception.*;


public class LtsvParser {
    public static List<LtsvLog> parse(String filePath) {
        List<String> lines;
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new LtsvIOException();
        }

        try {
            return lines.stream().map(line -> lineToLog(line)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw new LtsvParseException();
        }
    }

    private static LtsvLog lineToLog(String line) {
        Map<String, String> logMap = new HashMap<>();
        for (String field : line.split("\t")) {
            String[] kv = field.split(":", 2);
            logMap.put(kv[0], kv[1]);
        }

        return new LtsvLog(
                logMap.get("host"),
                logMap.get("user"),
                Integer.parseInt(logMap.get("epoch")),
                logMap.get("req"),
                Integer.parseInt(logMap.get("status")),
                Integer.parseInt(logMap.get("size")),
                logMap.get("referer")
        );
    }
}
