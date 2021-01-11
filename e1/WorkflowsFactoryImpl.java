package e1;

import java.util.List;
import java.util.Set;

public class WorkflowsFactoryImpl implements WorkflowsFactory {

	@Override
	public <T> Workflow<T> singleTask(T task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Workflow<T> tasksSequence(List<T> tasks) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Workflow<T> tasksJoin(Set<T> initialTasks, T finalTask) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Workflow<T> tasksFork(T initialTask, Set<T> finalTasks) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Workflow<T> concat(Workflow<T> first, Workflow<T> second) {
		// TODO Auto-generated method stub
		return null;
	}

}
