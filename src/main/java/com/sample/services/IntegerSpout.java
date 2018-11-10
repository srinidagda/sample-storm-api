package com.sample.services;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;

public class IntegerSpout extends BaseRichSpout{
	SpoutOutputCollector spoutOutputCollector;
	private Integer index = 0;
	@Override public void open(Map config, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
		this.spoutOutputCollector = spoutOutputCollector;
	}
	
	@Override public void nextTuple() {
		if (index < 100) {
			this.spoutOutputCollector.emit(new Values(index));
			index ++;
		}
	}
	
	@Override public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
		outputFieldsDeclarer.declare(new Fields("field"));
	}
}
