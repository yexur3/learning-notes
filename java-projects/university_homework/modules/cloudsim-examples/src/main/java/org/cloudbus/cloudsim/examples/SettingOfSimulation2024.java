package org.cloudbus.cloudsim.examples;


import org.cloudbus.cloudsim.*;

import java.util.List;

public class SettingOfSimulation2024 {

    public static int NUM_OF_CLOUDLETS = 1500;     // počet úloh (cloudletov);
    public static int NUM_OF_VMS = 20;           // počet VM (viruálnych strojov);
//    public static final String TYPE_OF_DATASET = "Dataset_type_5.txt";   // subor z ktoreho nacitavame dlzky uloh
//    public static String DEADLINE_FOR_DATASET = "Deadline_for_dataset_5.txt"; //subor z ktoreho nacitavame deadline uloh

    // csv súbor pre ukladanie výsledkov simulácií
    public static String NAME_OF_CSV_FILE = "Results_of_simulations.csv";

    public static String CLOUDLET_SCHEDULING_METHOD = "SpaceShared";
    public static final String VM_SCHEDULING_METHOD = "SpaceShared";

    //súčet obidvoch častí musí byť presne 100
    public static int PART_OF_SHORT_IOT_TASKS = 0; // percentuálny podiel krátkych IoT úloh v datasete
    public static int PART_OF_LONG_IOT_TASKS = 100; // percentuálny podiel dlhých IoT úloh v datasete


    public static CloudletScheduler setCloudletSchedulingMethod(){
        if (CLOUDLET_SCHEDULING_METHOD == "TimeShared"){
            return new CloudletSchedulerTimeShared();
        } else {
            return new CloudletSchedulerSpaceShared();
        }

    }

    public static VmScheduler setVMSchedulingMethod(List<? extends Pe> pelist){
        if (VM_SCHEDULING_METHOD == "TimeShared"){
            return new VmSchedulerTimeShared(pelist);
        } else {
            return new VmSchedulerSpaceShared(pelist);
        }
    }

    public static void setNumOfCloudlets(int count) {
        NUM_OF_CLOUDLETS = count;
    }

    public static void setNumOfVMs(int count) {
        NUM_OF_VMS = count;
    }

    public static void changeCloudletSchedulingMethod(){
        if (CLOUDLET_SCHEDULING_METHOD == "TimeShared"){
            CLOUDLET_SCHEDULING_METHOD = "SpaceShared";
        } else {
            CLOUDLET_SCHEDULING_METHOD = "TimeShared";
        }
    }
}