package gsis;

import java.util.HashMap;

import base.SimulationStarter;

public class InitRbacRHClean extends SimulationStarter {

	private int numManagers, numPosters, numConsumers;

	public InitRbacRHClean(int numManagers, int numPosters, int numConsumers) {
		this.numConsumers = numConsumers;
		this.numManagers = numManagers;
		this.numPosters = numPosters;
	}

	@Override
	public Rbac1State build() {
		Rbac1State ret = new Rbac1State();
		for(int i = 0; i < numPosters; i++) {
			String username = "p" + i;
			ret.addUser(username);
		}
		for(int i = 0; i < numManagers; i++) {
			String username = "m" + i;
			ret.addUser(username);
		}
		for(int i = 0; i < numConsumers; i++) {
			String username = "c" + i;
			ret.addUser(username);
		}
		return ret;
	}

	@Override
	public HashMap<String, Integer> buildActorMachine() {
		HashMap<String, Integer> ret = new HashMap<String, Integer>();
		ret.put("gsis.ActorPoster", numPosters);
		ret.put("gsis.ActorManager", numManagers);
		ret.put("gsis.ActorReader", numConsumers);
		return ret;
	}
}
