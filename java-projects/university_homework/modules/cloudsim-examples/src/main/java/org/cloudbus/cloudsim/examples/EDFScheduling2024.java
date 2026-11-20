package org.cloudbus.cloudsim.examples;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.Vm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.cloudbus.cloudsim.examples.CloudSimExample_EDF_algorithm.current_dataset_deadlines;
import static org.cloudbus.cloudsim.examples.CloudSimExample_EDF_algorithm.task_deadline;

public class EDFScheduling2024 {

  public static List<Cloudlet> schedule(List<Cloudlet> cloudletList, List<Vm> vmList) {
    List<Cloudlet> remainingCloudlets = new ArrayList<>(cloudletList);
    List<Cloudlet> scheduledCloudlets = new ArrayList<>();
    Map<Cloudlet, Vm> cloudletVmMap = new HashMap<>();

    while (!remainingCloudlets.isEmpty()) {
      Cloudlet selectedCloudlet = null;
      Vm selectedVm = null;
      double earliestDeadline = Double.MAX_VALUE;

      for (Cloudlet cloudlet : remainingCloudlets) {
        for (Vm vm : vmList) {
          double task_deadline = calculateTaskDeadline(cloudlet);

          if (task_deadline < earliestDeadline) {
            earliestDeadline = task_deadline;
            selectedCloudlet = cloudlet;
            selectedVm = vm;
          }
        }
      }

      if (selectedCloudlet != null) {
        cloudletVmMap.put(selectedCloudlet, selectedVm);
        scheduledCloudlets.add(selectedCloudlet);
        remainingCloudlets.remove(selectedCloudlet);
      }
    }

    return scheduledCloudlets;
  }

  private static double calculateTaskDeadline(Cloudlet cloudlet) {

//    task_deadline = deadline_for_IoT_tasks.get(cloudlet.getCloudletId());
    task_deadline = current_dataset_deadlines.get(cloudlet.getCloudletId());

    return task_deadline;
  }

}
