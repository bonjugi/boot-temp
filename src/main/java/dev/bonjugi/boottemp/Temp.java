package dev.bonjugi.boottemp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Temp {



	public static Map<String, Integer> finalMap = new HashMap<>();

	public static void sum(Map<String, Integer>  maps){

		Set<String> keySets = maps.keySet();

		Iterator<String> iterator = keySets.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();

			int mapCount = maps.get(key);

			if (finalMap.containsKey(key)) {
				int finalMapCount = finalMap.get(key);
				finalMap.put(key, finalMapCount + mapCount);
			} else {
				finalMap.put(key, mapCount);
			}

		}
	}

	public static Map<String, Integer> readDate(String fileName) {


		//반환용 리스트
		BufferedReader br = null;
		Map<String, Integer> maps = new HashMap<>();

		try {
			br = Files.newBufferedReader(Paths.get("/Users/bonjugi/Downloads/2019_total_statistics/" + fileName + ".csv"));
			Charset.forName("UTF-8");
			String line = "";


			int i=0;
			while ((line = br.readLine()) != null) {
				if (i == 0) {
					i++;
					continue;
				}
				//CSV 1행을 저장하는 리스트
				List<String> tmpList = new ArrayList<String>();
				String array[] = line.split(",");
				//배열에서 리스트 반환
				String momentCode = array[0];
				Integer count = Integer.parseInt(array[1]);

				maps.put(momentCode, count);

				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return maps;

	}


	public static void main(String[] args) {

		for (int i = 0; i < 16; i++) {
			String fileName = "pv_" + (i+1);
			Map<String, Integer> pvMap = readDate(fileName);

			sum(pvMap);
			System.out.println(fileName + "처리 : "  + pvMap );
			System.out.println("fianlMap : " + finalMap);


		}

	}

}
