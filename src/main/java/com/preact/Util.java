package com.preact;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Util {
	
	public static Map<String, Long> dataMerge(Iterator<Sales> it) {

		DateFormat format2 = new SimpleDateFormat("yyyy");
		Map<String, Long> map = new TreeMap<String, Long>();

		while (it.hasNext()) {
			Sales sa = (Sales) it.next();

			String key = format2.format(sa.getBookingDate()) + ", "
					+ sa.getAccount().getAccountCode() + ", "
					+ sa.getCurrency();
			long value = sa.getAmount();

			if (map.containsKey(key)) {
				map.put(key, map.get(key) + value);
			} else {
				map.put(key, value);
			}
		}
		return map;
	}

	public static void writeData2CSV(Map<String, Long> map, String fileName) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			// Title
			String title = "Year,AccountCode,Currency,Total\r\n";
			fw.write(title);

			String content = null;
			Iterator<Entry<String, Long>> iter = map.entrySet().iterator();

			while (iter.hasNext()) {
				Entry<String, Long> entry = (Entry<String, Long>) iter.next();
				content = entry.getKey() + ", " + entry.getValue() + "\r\n";
				fw.write(content);
			}
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}
}
