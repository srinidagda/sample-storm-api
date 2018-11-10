package com.sample.application;

import com.sample.services.IntegerSpout;
import com.sample.services.MutiplierBolt;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class TopologyDemo {
	public static void main(String args[]) {
		TopologyBuilder topologyBuilder = new TopologyBuilder();
		topologyBuilder.setSpout("IntegerSpout", new IntegerSpout());
		topologyBuilder.setBolt("MultiplierBolt", new MutiplierBolt()).shuffleGrouping("IntegerSpout");
		
		Config config = new Config();
		config.setDebug(true);
		
		LocalCluster cluster = new LocalCluster();
		try {
			cluster.submitTopology("Demo",config,topologyBuilder.createTopology());
			Thread.sleep(10000);
		} catch (Exception e) {
		
		}
		finally {
			cluster.shutdown();
		}
		
	}
}
