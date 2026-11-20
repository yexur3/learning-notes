package org.cloudbus.cloudsim.examples;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.Vm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static org.cloudbus.cloudsim.examples.IoT_experiments.CloudSimExampleMicroCloud_SJF_algorithmDobry.dataset_task_lengths;
//import static org.cloudbus.cloudsim.examples.IoT_experiments.CloudSimExampleMicroCloud_SJF_algorithmDobry.task_length;
import static org.cloudbus.cloudsim.examples.CloudSimExample_SJF_algorithm.task_length;

public class SJFScheduling2024 {

  public static List<Cloudlet> schedule(List<Cloudlet> cloudletList, List<Vm> vmList) {
    List<Cloudlet> remainingCloudlets = new ArrayList<>(cloudletList);
    List<Cloudlet> scheduledCloudlets = new ArrayList<>();
    Map<Cloudlet, Vm> cloudletVmMap = new HashMap<>();

    while (!remainingCloudlets.isEmpty()) {
      Cloudlet selectedCloudlet = null;
      Vm selectedVm = null;
      long minTaskLength = Long.MAX_VALUE;

      for (Cloudlet cloudlet : remainingCloudlets) {
        for (Vm vm : vmList) {
          long taskLength = calculateTaskLength(cloudlet);

          if (taskLength < minTaskLength) {
            minTaskLength = taskLength;
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

  private static long calculateTaskLength(Cloudlet cloudlet) {

    task_length = cloudlet.getCloudletLength();

    return task_length;
  }

}
