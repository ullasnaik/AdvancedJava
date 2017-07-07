package com.ullas.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamBasics {

	public static void main(String[] args) {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);
		matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);
		matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);
		long totalMatched = memberNames.stream().filter((s) -> s.startsWith("A")).count();
		System.out.println(totalMatched);
		Optional<String> reduced = memberNames.stream().reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);
		String firstMatchedName = memberNames.stream().filter((s) -> s.startsWith("L")).findFirst().get();
		System.out.println(firstMatchedName);

	}

}
