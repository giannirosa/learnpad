/**
 *
 */
package eu.learnpad.simulator.processmanager;

import java.util.Map;

import eu.learnpad.simulator.IProcessManager.TaskSubmissionStatus;

/**
 * This interface indicate the functionalities which must be exposed by a
 * process dispatcher. The role of a process dispatcher is, in the context of a
 * specific process, to signal to the UI which tasks must be sent to which
 * users, or the termination of the process itself.
 *
 * This interface allows the UI to informs the process dispatcher of tasks
 * completion.
 *
 * @author Tom Jorquera - Linagora
 *
 */
public interface IProcessDispatcher {

	/**
	 * Signal the completion of a given task, along with the corresponding
	 * proposed data
	 *
	 * @param taskId
	 *            the id of the completed task
	 * @param data
	 *            the data corresponding to the task completion
	 * @return the state of the task submission
	 */
	public TaskSubmissionStatus submitTaskCompletion(String taskId,
			Map<String, Object> data);
}
