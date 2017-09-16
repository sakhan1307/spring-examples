package com.springexample.sequence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class SequenceDaoImpl implements SequenceDao{
	private Map<String, Sequence> sequences;
	private Map<String, Integer> values;
	
	public SequenceDaoImpl() {
		sequences = new HashMap<String, Sequence>();
		sequences.put("IT", new Sequence("IT", "30", "A"));
		values = new HashMap<String, Integer>();
		values.put("IT", 100000);
	}
	public Sequence getSequence(String sequenceId) {
		return sequences.get(sequenceId);
	}
	public  int getNextValue(String sequenceId) {
		int value = values.get(sequenceId);
		values.put(sequenceId, value + 1);
		return value;
	}
}
