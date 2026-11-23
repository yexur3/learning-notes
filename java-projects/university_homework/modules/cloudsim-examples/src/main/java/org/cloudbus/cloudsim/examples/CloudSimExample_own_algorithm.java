/*
 * Title:        CloudSim Toolkit
 * Description:  CloudSim (Cloud Simulation) Toolkit for Modeling and Simulation
 *               of Clouds
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2009, The University of Melbourne, Australia
 */


package org.cloudbus.cloudsim.examples;

import org.apache.commons.math3.util.Precision;
import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

import java.io.File;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * An example showing how to create
 * scalable simulations.
 */
public class CloudSimExample_own_algorithm {

	/**
	 * The cloudlet list.
	 */
	private static List<Cloudlet> cloudletList;

	/**
	 * The vmlist.
	 */
	private static List<Vm> vmlist;

	//	Medzisúčty dĺžok úloh a Celkový súčet dĺžok úloh
	private static long live_tasks_lengths = 0;
	private static long all_tasks_lengths = 0;

	//	Celkový čas simulácie
	private static double simulation_time;

	//	parametre uloh (Cloudletov)
	public static long task_length = 0;

	public static long task_fileSize = 0;

	public static long task_outputSize = 0;

	//	parametre virtualnych strojov (VM)
	public static int vm_ram = 0;
	public static int vm_mips = 0;
	public static int vm_bw = 0;

	//	sucet dlzok uloh roznych typov
	public static long sum_tasks_lengths_0 = 0;
	public static long sum_tasks_lengths_1 = 0;
	public static long sum_tasks_lengths_2 = 0;
	public static long sum_tasks_lengths_3 = 0;

//	pocet uloh roznych typov
	public static int count_tasks_0 = 0;
	public static int count_tasks_1 = 0;
	public static int count_tasks_2 = 0;
	public static int count_tasks_3 = 0;
	public static int all_tasks_count = 0;


	//	pocet virtualnych strojov roznych typov
	public static int count_vm_0 = 0;
	public static int count_vm_1 = 0;
	public static int count_vm_2 = 0;
	public static int count_vm_3 = 0;
	public static int all_vm_count = 0;
	public static double avg_execution_time = 0.0;
	public static double count_cloudlets = 0;

	//	sucet MIPS virtualnych strojov VM
	public static long all_vm_mips = 0;
	public static long live_vm_mips = 0;

	//	efektivnost simulacie
	public static double simulation_effectiveness = 0;
	public static long ideal_time = 0;
	public static double completed_tasks = 0;
	public static double failed_tasks = 0;
	public static double percentage_of_failed_tasks = 0.0;

	public static int prediction_accuracy = -1;

    public static double complete_waiting_time = 0.0;
	public static double avg_waiting_time = 0.0;
	public static ArrayList<Long> dataset_task_lengths;
	public static ArrayList<Double> deadline_for_IoT_tasks;
	public static double task_deadline = 0.0;
	public static Double percentage_of_successful_IoT_tasks = 0.0;
	public static double successful_IoT_tasks = 0;
	public static double failed_IoT_tasks = 0;
//	private static double[] arrayOFVm;
//	private static double averageTime;
	public static List<Cloudlet> optimizedCloudletList;
	public static ArrayList<Long> lengths_for_IoT_type_1;
	public static ArrayList<Long> lengths_for_IoT_type_2;
	public static ArrayList<Double> deadlines_for_IoT_type_1;
	public static ArrayList<Double> deadlines_for_IoT_type_2;
	public static ArrayList<Double> current_dataset_deadlines = new ArrayList<>();

	private static final double TICK = 0.105;

	private static List<Vm> createVM(int userId, int vms) {

		//Creates a container to store VMs. This list is passed to the broker later
		LinkedList<Vm> list = new LinkedList<Vm>();

		//VM Parameters
		long size = 1000000; //image size (MB)
//		int ram = 512; //vm memory (MB)
//		int mips = 1000;
//		long bw = 1000;
		int pesNumber = 1; //number of cpus
		String vmm = "Xen"; //VMM name

		//create VMs
		Vm[] vm = new Vm[vms];

		for (int i = 0; i < vms; i++) {

//			generovanie parametrov VM zo zvolenych rozsahov
//			int random_generator = ThreadLocalRandom.current().nextInt(0, 4); //generovanie cisla v rozsahu 0-3



			if (i % 4 == 0) {
				vm_ram = 512; // vm memory (MB)
				vm_mips = 1000;
				vm_bw = 1000;
				pesNumber = 2;
				count_vm_0 = count_vm_0 + 1;
				System.out.println("Toto su parametre VM typu0 " + i);
				System.out.println("VM RAM ma kapacitu " + vm_ram);
				System.out.println("VM MPIS ma kapacitu " + vm_mips);
				System.out.println("VM BW ma kapacitu " + vm_bw);
				System.out.println("VM ma pocet jadier " + pesNumber);
				System.out.println(" ");

			} else if (i % 4 == 1) {
				vm_ram = 1024; // vm memory (MB)
				vm_mips = 2000;
				vm_bw = 1200;
				pesNumber = 2;
				count_vm_1 = count_vm_1 + 1;
				System.out.println("Toto su parametre VM typu1 " + i);
				System.out.println("VM RAM ma kapacitu " + vm_ram);
				System.out.println("VM MPIS ma kapacitu " + vm_mips);
				System.out.println("VM BW ma kapacitu " + vm_bw);
				System.out.println("VM ma pocet jadier " + pesNumber);
				System.out.println(" ");

			} else if (i % 4 == 2) {
				vm_ram = 2048; // vm memory (MB)
				vm_mips = 3000;
				vm_bw = 1400;
				pesNumber = 4;
				count_vm_2 = count_vm_2 + 1;
				System.out.println("Toto su parametre VM typu2 " + i);
				System.out.println("VM RAM ma kapacitu " + vm_ram);
				System.out.println("VM MPIS ma kapacitu " + vm_mips);
				System.out.println("VM BW ma kapacitu " + vm_bw);
				System.out.println("VM ma pocet jadier " + pesNumber);
				System.out.println(" ");

			} else if (i % 4 == 3){
				vm_ram = 4096; // vm memory (MB)
				vm_mips = 4000;
				vm_bw = 1600;
				pesNumber = 4;
				count_vm_3 = count_vm_3 + 1;
				System.out.println("Toto su parametre VM typu3 " + i);
				System.out.println("VM RAM ma kapacitu " + vm_ram);
				System.out.println("VM MPIS ma kapacitu " + vm_mips);
				System.out.println("VM BW ma kapacitu " + vm_bw);
				System.out.println("VM ma pocet jadier " + pesNumber);
				System.out.println(" ");
			}


			live_vm_mips = live_vm_mips + (vm_mips * pesNumber);
//			System.out.println("Toto je priebezny VM v mips " + live_vm_mips);

//			uloženie celkového súčtu vm mips
			if (i == vms - 1) {
				all_vm_mips = live_vm_mips;
				all_vm_count = count_vm_0 + count_vm_1 + count_vm_2 + count_vm_3;
			}

			//for creating a VM with a time shared and space shared scheduling policy for cloudlets:

//			vm[i] = new Vm(i, userId, vm_mips, pesNumber, vm_ram, vm_bw, size, vmm, new CloudletSchedulerTimeShared());
			vm[i] = new Vm(i, userId, vm_mips, pesNumber, vm_ram, vm_bw, size, vmm, SettingOfSimulation2024.setCloudletSchedulingMethod());


			list.add(vm[i]);
		}

		return list;
	}


	private static List<Cloudlet> createCloudlet(int userId, int cloudlets) {
		// Creates a container to store Cloudlets
		LinkedList<Cloudlet> list = new LinkedList<Cloudlet>();

		//cloudlet parameters
//		long length = 1000;
//		long fileSize = 300;
//		long outputSize = 300;
		count_cloudlets = cloudlets;
		int pesNumber = 1;
		UtilizationModel utilizationModel = new UtilizationModelFull();

		Cloudlet[] cloudlet = new Cloudlet[cloudlets];

		int num_of_short_IoT_tasks = (int) Math.floor(cloudlets * ((double) SettingOfSimulation2024.PART_OF_SHORT_IOT_TASKS / 100));
		int num_of_long_IoT_tasks = (int) Math.ceil(cloudlets * ((double) SettingOfSimulation2024.PART_OF_LONG_IOT_TASKS / 100));

		for (int i = 0; i < cloudlets; i++) {

//			generovanie parametrov uloh (Cloudletov) zo zvolenych rozsahov
		if (num_of_short_IoT_tasks != 0 && num_of_long_IoT_tasks != 0){

			if (i % 2 == 0){
				task_length = lengths_for_IoT_type_1.get(i);
				task_deadline = deadlines_for_IoT_type_1.get(i);
				current_dataset_deadlines.add(i, task_deadline);
				task_fileSize = ThreadLocalRandom.current().nextLong(10, 20 + 1);
				task_outputSize = ThreadLocalRandom.current().nextLong(10, 20 + 1);
				sum_tasks_lengths_1 = sum_tasks_lengths_1 + task_length;
				count_tasks_1 = count_tasks_1 + 1;
				pesNumber = 1;
				num_of_short_IoT_tasks--;
				System.out.println("Toto su parametre ulohy IoT ulohy typu 1 " + i);
				System.out.println("Task Length = " + task_length);
				System.out.println("Deadline = " + task_deadline);
				System.out.println("Task FileSize = " + task_fileSize);
				System.out.println("Task OutputSize = " + task_outputSize);
				System.out.println("Pocet vyzadovanych jadier je = " + pesNumber);
				System.out.println(" ");

			} else if (i % 2 == 1){
				task_length = lengths_for_IoT_type_2.get(i);
				task_deadline = deadlines_for_IoT_type_2.get(i);
				current_dataset_deadlines.add(i, task_deadline);
				task_fileSize = ThreadLocalRandom.current().nextLong(10, 20 + 1);
				task_outputSize = ThreadLocalRandom.current().nextLong(10, 20 + 1);
				sum_tasks_lengths_2 = sum_tasks_lengths_2 + task_length;
				count_tasks_2 = count_tasks_2 + 1;
				pesNumber = 1;
				num_of_long_IoT_tasks--;
				System.out.println("Toto su parametre ulohy IoT ulohy typu 2 " + i);
				System.out.println("Task Length = " + task_length);
				System.out.println("Deadline = " + task_deadline);
				System.out.println("Task FileSize = " + task_fileSize);
				System.out.println("Task OutputSize = " + task_outputSize);
				System.out.println("Pocet vyzadovanych jadier je = " + pesNumber);
				System.out.println(" ");
			}
	}else if (num_of_short_IoT_tasks == 0){
			task_length = lengths_for_IoT_type_2.get(i);
			task_deadline = deadlines_for_IoT_type_2.get(i);
			current_dataset_deadlines.add(i, task_deadline);
			task_fileSize = ThreadLocalRandom.current().nextLong(10, 20 + 1);
			task_outputSize = ThreadLocalRandom.current().nextLong(10, 20 + 1);
			sum_tasks_lengths_2 = sum_tasks_lengths_2 + task_length;
			count_tasks_2 = count_tasks_2 + 1;
			pesNumber = 1;
//			num_of_long_IoT_tasks--;
			System.out.println("Toto su parametre ulohy IoT ulohy typu 2 " + i);
			System.out.println("Task Length = " + task_length);
			System.out.println("Deadline = " + task_deadline);
			System.out.println("Task FileSize = " + task_fileSize);
			System.out.println("Task OutputSize = " + task_outputSize);
			System.out.println("Pocet vyzadovanych jadier je = " + pesNumber);
			System.out.println(" ");
		}else if (num_of_long_IoT_tasks == 0) {
			task_length = lengths_for_IoT_type_1.get(i);
			task_deadline = deadlines_for_IoT_type_1.get(i);
			current_dataset_deadlines.add(i, task_deadline);
			task_fileSize = ThreadLocalRandom.current().nextLong(10, 20 + 1);
			task_outputSize = ThreadLocalRandom.current().nextLong(10, 20 + 1);
			sum_tasks_lengths_1 = sum_tasks_lengths_1 + task_length;
			count_tasks_1 = count_tasks_1 + 1;
			pesNumber = 1;
//			num_of_short_IoT_tasks--;
			System.out.println("Toto su parametre ulohy IoT ulohy typu 1 " + i);
			System.out.println("Task Length = " + task_length);
			System.out.println("Deadline = " + task_deadline);
			System.out.println("Task FileSize = " + task_fileSize);
			System.out.println("Task OutputSize = " + task_outputSize);
			System.out.println("Pocet vyzadovanych jadier je = " + pesNumber);
			System.out.println(" ");
		}

//			vypisovanie medzisúčtov dĺžok úloh
			live_tasks_lengths = live_tasks_lengths + (task_length * pesNumber);
//			System.out.println("Aktuálny medzisúčet dĺžok úloh je : " + live_tasks_lengths);

//			uloženie celkového súčtu dĺžok úloh
			if (i == cloudlets - 1) {
				all_tasks_lengths = (live_tasks_lengths);
				all_tasks_count = count_tasks_0 + count_tasks_1 + count_tasks_2 + count_tasks_3;
				System.out.println("Short IoT tasks " + count_tasks_1 + " Long IoT tasks " + count_tasks_2);
				System.out.println(current_dataset_deadlines);
			}

			cloudlet[i] = new Cloudlet(i, task_length, pesNumber, task_fileSize, task_outputSize, utilizationModel, utilizationModel, utilizationModel);
			// setting the owner of these Cloudlets
			cloudlet[i].setUserId(userId);
			list.add(cloudlet[i]);
		}

		return list;
	}


	////////////////////////// STATIC METHODS ///////////////////////

	/**
	 * Creates main() to run this example
	 */
		public static void main (String[]args) {

            Log.printLine("Starting CloudSimExample6...");
            if (SettingOfSimulation2024.PART_OF_SHORT_IOT_TASKS + SettingOfSimulation2024.PART_OF_LONG_IOT_TASKS != 100.00) {
				System.out.println("Percento uloh z datasetov sa nerovna 100 !!!!!!!");
				System.exit(1);
			} else {

                try {
					// First step: Initialize the CloudSim package. It should be called
					// before creating any entities.
					int num_user = 1;   // number of grid users
					Calendar calendar = Calendar.getInstance();
					boolean trace_flag = false;  // mean trace events

					// Initialize the CloudSim library
					CloudSim.init(num_user, calendar, trace_flag);

					// Second step: Create Datacenters
					//Datacenters are the resource providers in CloudSim. We need at list one of them to run a CloudSim simulation
					@SuppressWarnings("unused")
					Datacenter datacenter0 = createDatacenter("Datacenter_0");
					@SuppressWarnings("unused")
//					Datacenter datacenter1 = createDatacenter("Datacenter_1");


					//Third step: Create Broker
					DatacenterBroker broker = createBroker();
					int brokerId = broker.getId();

					//nacitanie dlzok uloh zo suborov txt o datasetoch
					lengths_for_IoT_type_1 = readDatasetFromFile("Dataset_type_4.txt");
					lengths_for_IoT_type_2 = readDatasetFromFile("Dataset_type_5.txt");

					//nacitanie deadlines uloh zo suborov txt o datasetoch
					deadlines_for_IoT_type_1 = readDeadlineFromFile("Deadline_for_dataset_4.txt");
					deadlines_for_IoT_type_2 = readDeadlineFromFile("Deadline_for_dataset_5.txt");

					//Fourth step: Create VMs and Cloudlets and send them to broker
					vmlist = createVM(brokerId, SettingOfSimulation2024.NUM_OF_VMS); //creating 20 vms
					cloudletList = createCloudlet(brokerId, SettingOfSimulation2024.NUM_OF_CLOUDLETS);// creating 40 cloudlets

//					Nahodne preusporiadanie pola s ulohami
//					Collections.shuffle(cloudletList);

					mojAlgoritmus();

					broker.submitVmList(vmlist);
					broker.submitCloudletList(cloudletList);


//					obmedzenie doby trvania simulácie
//					CloudSim.terminateSimulation(100.00);

					// Fifth step: Starts the simulation
					CloudSim.startSimulation();


                    // Final step: Print results when simulation is over
					List<Cloudlet> newList = broker.getCloudletReceivedList();

					CloudSim.stopSimulation();

					printCloudletList(newList);

					Log.printLine("CloudSimExample6 finished!");

//			vypocet priemerneho času spracovania jednej ulohy v danom simulatore
					avg_execution_time = simulation_time / count_cloudlets;
					avg_execution_time = (Precision.round(avg_execution_time, 4));

//			vypocet efektivnosti simulacie
					ideal_time = all_tasks_lengths / all_vm_mips;
					simulation_effectiveness = (ideal_time / simulation_time) * 100;
					simulation_effectiveness = (Precision.round(simulation_effectiveness, 4));


					System.out.println(" ");
					System.out.println("Celkový súčet dĺžok úloh je: " + all_tasks_lengths);
					System.out.println("Celkový súčet mips vm je: " + all_vm_mips);
					System.out.println("Ideálny čas trvania simulacie je: " + ideal_time);
					System.out.println("Celkový čas trvania simulácie je: " + simulation_time);
					System.out.println("Efektívnosť simulácie je: " + simulation_effectiveness);
					System.out.println("Priemerný čas spracovania jednej úlohy je: " + avg_execution_time);
					System.out.println("Uloh typu0: " + count_tasks_0 + " Uloh typu1: " + count_tasks_1 + " Uloh typu2: " + count_tasks_2 + " Uloh typu3: " + count_tasks_3);
					System.out.println("Počet vsetkých úloh je " + all_tasks_count);

//					počet úspešne a neúspešne priradených úloh a vypocet percenta neuspesne priradenych uloh
					failed_tasks = all_tasks_count - completed_tasks;
					percentage_of_failed_tasks = (failed_tasks / (completed_tasks + failed_tasks)) * 100;
					percentage_of_failed_tasks = Precision.round(percentage_of_failed_tasks, 4);

					System.out.println("Počet úspešne priradených úloh je " + completed_tasks);
					System.out.println("Počet neúspešne priradených úloh je " + failed_tasks);
					System.out.println("Percento neúspešne priradených úloh je " + percentage_of_failed_tasks + " %");


//					počet úspešne a neúspešne priradených úloh a vypocet percenta uspesne priradenych uloh
					double number_of_IoT_tasks = 0;
					number_of_IoT_tasks = successful_IoT_tasks + failed_IoT_tasks;

					percentage_of_successful_IoT_tasks = (successful_IoT_tasks / number_of_IoT_tasks * 100);
					percentage_of_successful_IoT_tasks = Precision.round(percentage_of_successful_IoT_tasks, 4);

					//zapis vysledkov simulacie do csv suboru
					zapisDataDoCSVSuboru(vytvorPoleStringov());

					System.out.println("Počet úspešne priradených IoT úloh je " + successful_IoT_tasks);
					System.out.println("Počet neúspešne priradených IoT úloh je " + failed_IoT_tasks);
					System.out.println("Percento úspešne priradených IoT úloh je " + percentage_of_successful_IoT_tasks + " %");

//					obnovenie statickych premennych
					restore_static_variables();

				} catch (Exception e) {
					e.printStackTrace();
					Log.printLine("The simulation has been terminated due to an unexpected error");
				}

            }
        }


	public static void mojAlgoritmus() {

		// vytvarame maticu: riadok je jeden virtualny stroj (vm), stlpec je jadro tohto vm
		// hodnota v matici je cas, kedy sa dane jadro uvolni
		// vdaka tomu sledujeme, ktore jadra su obsadene a dokedy
		// jadra pre jednotlive riadky vytvarame v cykle nizsie
		double[][] slotReady = new double[vmlist.size()][];

		// pre kazdy vm vytvarame stlpce (jadra) a hned kazde jadro naplname hodnotou 0.1
		// 0.1 nie je nahodne, vo vystupe simulacie je vidno, ze prva uloha na kazdom jadre zacina o 0.1 s, nie o 0 s
		for (Vm vm : vmlist){
			slotReady[vm.getId()] = new double[vm.getNumberOfPes()];
			Arrays.fill(slotReady[vm.getId()], 0.1);
		}

		// vytvarame dva zoznamy uloh
		// onTime: ulohy, ktore sa podla nasho modelu stihnu dokoncit pred deadlinom
		// deferred: ulohy, ktore sa podla modelu nestihnu; nezahadzujeme ich, ale zaradime ich na koniec fronty
		List<Cloudlet> onTime = new ArrayList<>();
		List<Cloudlet> deferred = new ArrayList<>();

		// prechadzame zoznam uloh postupne, v poradi ako su v zozname, a pre kazdu ulohu vyberame najlepsi vm
		for (Cloudlet c : cloudletList){

			// najlepsi cas dokoncenia ulohy, ktory sme zatial nasli (zaciname s najvacsim moznym cislom, aby prvy kandidat vzdy vyhral)
			// najlepsi vm a cislo jeho jadra, potrebujeme ich na priradenie ulohy a aktualizaciu slotReady
			// deklarujeme ich vo vnutri cyklu, aby sa pre kazdu novu ulohu hladalo odznova
			double bestTime = Double.MAX_VALUE;
			Vm bestVm = null;
			int bestSlot = 0;

			// prechadzame vm jeden po druhom a pre kazdy pocitame, kedy by v nom skoncila tato uloha
			for (Vm vm : vmlist){

				// hladame jadro, ktore sa uvolni najskor, a cas dokoncenia pocitame len pre neho
				// dovod: na ktore jadro pojde uloha, rozhoduje cloudsim, a ten ju vzdy da na jadro, ktore sa uvolni ako prve
				// my vyberame len vm, jadro vo vnutri vm nevyberame
				// keby sme pocitali cas pre ine jadro, predpovedali by sme nieco, co sa v simulacii nestane, a model by sa rozisiel s realitou
				// index na zaciatku ukazuje na jadro 0 a porovnavame ho s ostatnymi jadrami (od j = 1)
				// index deklarujeme vo vnutri cyklu, aby sa pre kazdy vm zacinalo odznova
				int index = 0;
				for(int j = 1; j < vm.getNumberOfPes(); j++) {
					if (slotReady[vm.getId()][j] < slotReady[vm.getId()][index]) {
						index = j;
					}
				}

				// vypocitame, ako dlho uloha obsadi jadro
				// cas podla vzorca (dlzka / mips) zaokruhlujeme nahor na cely pocet taktov, lebo podla mojho pozorovania cloudsim aktualizuje stav vykonavania len v taktoch a ulohu vidi ako dokoncenu az na najblizsom takte
				// zaokruhlujeme nahor, nie na najblizsie cele cislo, pretoze inak by model niekedy predpokladal skorsie dokoncenie, ako v simulacii skutocne nastane
				// TICK (0.105 s) je priblizna hodnota, ktoru som zistil pozorovanim vystupu simulacie
				double duration = Math.ceil((c.getCloudletLength() / vm.getMips()) / TICK) * TICK;
				// cas dokoncenia tejto ulohy = cas, kedy sa jadro uvolni, plus trvanie ulohy
				// ulohy na jadre idu za sebou, takze je to zaroven cas, kedy sa jadro uvolni znova
				double timeOfEnding = slotReady[vm.getId()][index] + duration;

				// porovname cas dokoncenia s najlepsim casom, ktory sme zatial nasli
				// ak je lepsi (mensi), zapamatame si ho ako noveho kandidata: cas, vm aj cislo jadra
				// vsetky tri hodnoty menime spolu, lebo popisuju jeden a ten isty variant; keby sme zmenili len cas, uloha by sa priradila inemu vm, ako sme pocitali, a aktualizovalo by sa nespravne jadro
				// konecne rozhodnutie robime az po prejdeni vsetkych vm, tu si len pamatame najlepsieho kandidata
				// pri rovnakom case ostane prvy najdeny vm (porovnavame striktne <)
				if(timeOfEnding < bestTime) {
					bestTime = timeOfEnding;
					bestVm = vm;
					bestSlot = index;
				}

			}

			// tu kontrolujeme, ci ulohu stihneme dokoncit pred deadlinom, ak ju priradime k tomuto vm
			// ak ju stihneme, ulozime si to, pridame ju do zoznamu uloh, ktore stihaju deadline, a zapiseme ju do matice na dalsie vypocty uz s ohladom na tuto ulohu
			// ak ju nestihneme, prida sa do ineho zoznamu a neskor bude zaradena do zoznamu vsetkych uloh ako posledna, pretoze najprv sa budu vykonavat ulohy, ktore stihaju deadline
			// kedze tieto ulohy podla modelu deadline nestihnu v kazdom pripade, vykonaju sa ako posledne, aby zbytocne neobtazovali jadra, ktore moze vyuzit ina uloha, ktora deadline este stihnut moze
			if (bestTime <= current_dataset_deadlines.get(c.getCloudletId())){
				c.setVmId(bestVm.getId());
				slotReady[bestVm.getId()][bestSlot] = bestTime;
				onTime.add(c);
			} else {
				deferred.add(c);
			}

		}

		// tu znova postupne prechadzame zoznam uloh, tentokrat len ulohy, ktore podla modelu deadline nestihali
		// priradujeme ich k vm podla toho, kam sa najlepsie hodia
		// budu sa vykonavat ako posledne
		for (Cloudlet c : deferred){

			// vytvarame tie iste premenne ako pri beznych ulohach v prvom cykle, kde sme prechadzali cely zoznam uloh
			double bestTime = Double.MAX_VALUE;
			Vm bestVm = null;
			int bestSlot = 0;

			// rovnako pocitame len pre jadro, ktore sa uvolni najskor, v tomto vm pre tuto ulohu
			for (Vm vm : vmlist){
				int index = 0;
				for (int j = 1; j < vm.getNumberOfPes(); j++){
					if (slotReady[vm.getId()][j] < slotReady[vm.getId()][index]){
						index = j;
					}
				}

				// robime tu rovnaky vypocet
				double duration = Math.ceil((c.getCloudletLength() / vm.getMips()) / TICK) * TICK;
				double timeOfEnding = slotReady[vm.getId()][index] + duration;

				// a rovnako kontrolujeme cas a zapamatame si vsetky udaje najlepsieho vm a najlepsieho jadra pre tuto ulohu
				if (timeOfEnding < bestTime) {
					bestTime = timeOfEnding;
					bestVm = vm;
					bestSlot = index;
				}
			}

			// po prejdeni celeho zoznamu vm priradime ulohu k vm, ktory bol pre nu najlepsi
			// a zapiseme to do matice pre spravne vypocty v buducnosti
			c.setVmId(bestVm.getId());
			slotReady[bestVm.getId()][bestSlot] = bestTime;

		}

		// tu vytvarame zoznam vsetkych uloh: najprv do neho pridame ulohy, ktore stihaju deadline, tie sa maju vykonat prve, a po nich budu nasledovat ulohy, ktore deadline nestihaju
		cloudletList = new ArrayList<>();
		cloudletList.addAll(onTime);
		cloudletList.addAll(deferred);

	}



	public static void zapisDataDoCSVSuboru(String[] poleNaZapis) throws IOException {
		File subor = new File(SettingOfSimulation2024.NAME_OF_CSV_FILE);

		FileWriter fr = new FileWriter(subor, true);

		BufferedWriter br = new BufferedWriter(fr);

		br.newLine();

		for (int col = 0; col < poleNaZapis.length; col++) {
			br.write((poleNaZapis[col]) + ",");
		}

//		vyvtvorenie hlavicky csv suboru
//		br.write("simulation_effectiveness"+","+"simulation_time"+","+"alg_task_vm"+","+"complete_waiting_time"
//				+","+"avg_waiting_time"+","+"all_tasks_lengths"+","+"all_vm_mips"+","+"all_tasks_count"+","
//				+"count_tasks_4"+","+"count_tasks_3"+","+"count_tasks_1"+","+"count_tasks_2"+","+"count_vm_7"+","
//				+"count_vm_6"+","+"count_vm_5"+","+"count_vm_4"+","+"percentage_of_failed_tasks"+",");


		br.close();
	}

	public static String[] vytvorPoleStringov() {

		String[] poleRetazcov = new String[21];
		poleRetazcov[0] = SettingOfSimulation2024.PART_OF_SHORT_IOT_TASKS + "/" + SettingOfSimulation2024.PART_OF_LONG_IOT_TASKS;
		poleRetazcov[1] = String.valueOf(all_tasks_count);
		poleRetazcov[2] = "Sapa_algorithm";
		poleRetazcov[3] = String.valueOf(percentage_of_successful_IoT_tasks);
		poleRetazcov[4] = String.valueOf(simulation_time);
		poleRetazcov[5] = String.valueOf(successful_IoT_tasks);
		poleRetazcov[6] = String.valueOf(count_tasks_1);
		poleRetazcov[7] = String.valueOf(count_tasks_2);
		poleRetazcov[8] = String.valueOf(all_tasks_lengths);
		poleRetazcov[9] = String.valueOf(all_vm_mips);
		poleRetazcov[10] = String.valueOf(all_vm_count);
		poleRetazcov[11] = SettingOfSimulation2024.CLOUDLET_SCHEDULING_METHOD;
		poleRetazcov[12] = SettingOfSimulation2024.VM_SCHEDULING_METHOD;
		poleRetazcov[13] = String.valueOf(complete_waiting_time);
		poleRetazcov[14] = String.valueOf(avg_waiting_time);
		poleRetazcov[15] = String.valueOf(count_vm_0);
		poleRetazcov[16] = String.valueOf(count_vm_1);
		poleRetazcov[17] = String.valueOf(count_vm_2);
		poleRetazcov[18] = String.valueOf(count_vm_3);
		poleRetazcov[19] = String.valueOf(percentage_of_failed_tasks);
		poleRetazcov[20] = String.valueOf(simulation_effectiveness);

		return poleRetazcov;
	}


	private static Datacenter createDatacenter(String name) {

		// Here are the steps needed to create a PowerDatacenter:
		// 1. We need to create a list to store one or more
		//    Machines
		List<Host> hostList = new ArrayList<Host>();

		// 2. A Machine contains one or more PEs or CPUs/Cores. Therefore, should
		//    create a list to store these PEs before creating
		//    a Machine.
		List<Pe> peList1 = new ArrayList<Pe>();

		int mips = 20000;

		// 3. Create PEs and add these into the list.
		//for a quad-core machine, a list of 4 PEs is required:

		for (int peCount = 0; peCount < 12; peCount++){  //19 cores
			peList1.add(new Pe(peCount, new PeProvisionerSimple(mips)));
//			System.out.println("Host cislo " + peCount);
		}

//		peList1.add(new Pe(0, new PeProvisionerSimple(mips))); // need to store Pe id and MIPS Rating
//		peList1.add(new Pe(1, new PeProvisionerSimple(mips)));
//		peList1.add(new Pe(2, new PeProvisionerSimple(mips)));
//		peList1.add(new Pe(3, new PeProvisionerSimple(mips)));

		//Another list, for a dual-core machine
//		List<Pe> peList2 = new ArrayList<Pe>();
//
//		for (int peCount = 0; peCount < 61; peCount++){   //36 cores
//			peList2.add(new Pe(peCount, new PeProvisionerSimple(mips)));
////			System.out.println("Host cislo " + peCount);
//		}

//		peList2.add(new Pe(0, new PeProvisionerSimple(mips)));
//		peList2.add(new Pe(1, new PeProvisionerSimple(mips)));


//		for (int peCount = 0; peCount < 36; peCount++){
//			peList3.add(new Pe(peCount, new PeProvisionerSimple(mips)));
//		}

		//4. Create Hosts with its id and list of PEs and add them to the list of machines
		int hostId = 0;
		int ram = 140880; //host memory (MB)
		long storage = 1000000000; //host storage
		int bw = 200000000;

		for (int hostCount = 0; hostCount < 12 ; hostCount++) {

			hostList.add(new Host(hostCount, new RamProvisionerSimple(ram), new BwProvisionerSimple(bw), storage,
					peList1, SettingOfSimulation2024.setVMSchedulingMethod(peList1)));
//			hostId = hostCount;
		}
//			hostList.add(
//					new Host(
//							hostId,
//							new RamProvisionerSimple(ram),
//							new BwProvisionerSimple(bw),
//							storage,
//							peList1,
//							new VmSchedulerTimeShared(peList1)
//						new VmSchedulerSpaceShared(peList1)
//						new VmSchedulerTimeSharedOverSubscription(peList1)
//					)
//			); // This is our first machine
//			hostId = hostCount;
//		}

//		hostId++;

//		for (int hostCount = hostId + 1; hostCount < hostId + 1 + 10; hostCount++) {
//
//			hostList.add(new Host(hostCount, new RamProvisionerSimple(ram), new BwProvisionerSimple(bw), storage,
//					peList2, SettingOfSimulation.setVMSchedulingMethod(peList2)));
//		}
//			hostList.add(
//					new Host(
//							hostId,
//							new RamProvisionerSimple(ram),
//							new BwProvisionerSimple(bw),
//							storage,
//							peList2,
//							new VmSchedulerTimeShared(peList2)
//						new VmSchedulerSpaceShared(peList2)
//						new VmSchedulerTimeSharedOverSubscription(peList2)

//					)
//			);
//			hostId = hostCount;
//		}


//		for (int hostCount = hostId + 1; hostCount < hostId + 1 + 10; hostCount++) {
//		}

		// Second machine


		//To create a host with a space-shared allocation policy for PEs to VMs:
		//hostList.add(
		//		new Host(
		//			hostId,
		//			new CpuProvisionerSimple(peList1),
		//			new RamProvisionerSimple(ram),
		//			new BwProvisionerSimple(bw),
		//			storage,
		//			new VmSchedulerSpaceShared(peList1)
		//		)
		//	);

		//To create a host with a oportunistic space-shared allocation policy for PEs to VMs:
//		hostList.add(
//				new Host(
//					hostId,
//					new CpuProvisionerSimple(peList1),
//					new RamProvisionerSimple(ram),
//					new BwProvisionerSimple(bw),
//					storage,
//					new VmSchedulerOportunisticSpaceShared(peList1)
//				)
//			);


		// 5. Create a DatacenterCharacteristics object that stores the
		//    properties of a data center: architecture, OS, list of
		//    Machines, allocation policy: time- or space-shared, time zone
		//    and its price (G$/Pe time unit).
		String arch = "x86";      // system architecture
		String os = "Linux";          // operating system
		String vmm = "Xen";
		double time_zone = 10.0;         // time zone this resource located
		double cost = 3.0;              // the cost of using processing in this resource
		double costPerMem = 0.05;        // the cost of using memory in this resource
		double costPerStorage = 0.1;    // the cost of using storage in this resource
		double costPerBw = 0.1;            // the cost of using bw in this resource
		LinkedList<Storage> storageList = new LinkedList<Storage>();    //we are not adding SAN devices by now

		DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
				arch, os, vmm, hostList, time_zone, cost, costPerMem, costPerStorage, costPerBw);


		// 6. Finally, we need to create a PowerDatacenter object.
		Datacenter datacenter = null;
		try {
			datacenter = new Datacenter(name, characteristics, new VmAllocationPolicySimple(hostList), storageList, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return datacenter;
	}

	//We strongly encourage users to develop their own broker policies, to submit vms and cloudlets according
	//to the specific rules of the simulated scenario
	private static DatacenterBroker createBroker() {

		DatacenterBroker broker = null;
		try {
			broker = new DatacenterBroker("Broker");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return broker;
	}

	/**
	 * Prints the Cloudlet objects
	 *
	 * @param list list of Cloudlets
	 */
	private static void printCloudletList(List<Cloudlet> list) throws FileNotFoundException {
		int size = list.size();
		Cloudlet cloudlet;

		ArrayList<Integer>[] schedule_list = new ArrayList[all_vm_count];

		ArrayList<Double>[] finish_time_list = new ArrayList[all_vm_count];


		// inicializácia schedule listu
		for (int i = 0; i < all_vm_count; i++) {
			schedule_list[i] = new ArrayList<Integer>();
		}


		// inicializacia finish time lsitu
		for (int i = 0; i < all_vm_count; i++) {
			finish_time_list[i] = new ArrayList<Double>();
			finish_time_list[i].add(Double.valueOf(i));
			finish_time_list[i].add(0.0);
		}


		int all_cloudlet_count = size;
		System.out.println("Pocet uloh " + all_cloudlet_count);


		String indent = "    ";
		Log.printLine();
		Log.printLine("========== OUTPUT ==========");
		Log.printLine("Cloudlet ID" + indent + "STATUS" + indent +
				"Data center ID" + indent + "VM ID" + indent + indent + "Time" + indent + "Start Time" + indent + "Finish Time");

		DecimalFormat dft = new DecimalFormat("###.##");
		for (int i = 0; i < size; i++) {
			cloudlet = list.get(i);
			Log.print(indent + cloudlet.getCloudletId() + indent + indent);

			if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS) {
				Log.print("SUCCESS");
				completed_tasks = completed_tasks + 1;

//				uloženie celkového času simulacie so zaokruhlenim na 2 desatinne miesta a pretypovanim na String
				if (i == size - 1) {
					simulation_time = (Precision.round(cloudlet.getFinishTime(), 2));
				}

				Log.printLine(indent + indent + cloudlet.getResourceId() + indent + indent + indent + cloudlet.getVmId() +
						indent + indent + indent + dft.format(cloudlet.getActualCPUTime()) +
						indent + indent + dft.format(cloudlet.getExecStartTime()) + indent + indent + indent + dft.format(cloudlet.getFinishTime())
				  		+ indent + indent + i + indent + indent + current_dataset_deadlines.get(cloudlet.getCloudletId()));



//				Nacitanie deadlinov IoT uloh podla pouziteho datasetu
				task_deadline = current_dataset_deadlines.get(cloudlet.getCloudletId());

				System.out.println("Uloha s ID " + cloudlet.getCloudletId() + " ma deadline  " + task_deadline + "a dlzku " + cloudlet.getCloudletLength());

				//Rozhodovanie o tom ci bol deadline IoT uloh splneny
				if(task_deadline >= cloudlet.getFinishTime()) {
					System.out.println("Deadline je " + task_deadline + " Cas dokoncenia ulohy " + cloudlet.getFinishTime());
					successful_IoT_tasks++;
				} else {
					System.out.println("Uloha s ID " + cloudlet.getCloudletId() + " nesplnila svoj deadline pretoze " + cloudlet.getFinishTime() +" > " + task_deadline + " !!!");
					failed_IoT_tasks++;
				}


//				if (cloudlet.getCloudletLength() >= 100 && cloudlet.getCloudletLength() <= 400 + 1){
//					if (SettingOfSimulation.TYPE_OF_DATASET == "Dataset_type_4.txt"){
//						task_deadline = deadline_for_IoT_type_1.get(cloudlet.getCloudletId());
//					} else {
//						task_deadline = deadline_for_IoT_type_3.get(cloudlet.getCloudletId());
//					}
//
//					System.out.println("Uloha s ID " + cloudlet.getCloudletId() + " ma deadline  " + task_deadline + "a dlzku " + cloudlet.getCloudletLength());
//
//				} else if (cloudlet.getCloudletLength() >= 500 && cloudlet.getCloudletLength() <= 800 + 1) {
//					if(SettingOfSimulation.TYPE_OF_DATASET == "Dataset_type_5.txt"){
//						task_deadline = deadline_for_IoT_type_2.get(cloudlet.getCloudletId());
//					} else {
//						task_deadline = deadline_for_IoT_type_3.get(cloudlet.getCloudletId());
//					}
//
//					System.out.println("Uloha s ID " + cloudlet.getCloudletId() + " ma deadline  " + task_deadline + "a dlzku " + cloudlet.getCloudletLength());
//				}


//				if (cloudlet.getCloudletId() == 100) {
//					Double task_deadline1 = deadline_for_IoT_type_1.get(cloudlet.getCloudletId());
//					System.out.println("Toto je deadline 10 IoT ulohy typu 1 "+ task_deadline1);
//					System.out.println("Toto je dlzka danej ulohy " + cloudlet.getCloudletLength());
//				}


//				pridávanie id cloudletov do Arraylistu s virtuálnymi strojmi
				int vm_id = cloudlet.getVmId();
				int cloudlet_id = cloudlet.getCloudletId();
				schedule_list[vm_id].add(cloudlet_id);


//				naplnanie finish time listu casmi dokoncenia poslednych uloh na jednotlivych virtualnych strojoch
				double taskFinishTime = cloudlet.getFinishTime();

				if (taskFinishTime > finish_time_list[vm_id].get(1)){
					finish_time_list[vm_id].set(1, Precision.round(taskFinishTime, 2));
				}

			}
		}




//		Zobrazenie cloudletov, ktoré boli spracované na virtuálnych strojoch
		System.out.println(" ");
		System.out.println("Tabuľka priradenia úloh na virtuálne stroje");
		for (int i = 0; i < all_vm_count; i++) {
			System.out.println("VM " + i);
			for (int j = 0; j < schedule_list[i].size(); j++) {
				System.out.print(schedule_list[i].get(j) + " ");
			}
			System.out.println();
		}



		// Zobrazenie tabulky casov dokoncenia uloh na virtualnych strojoch
		System.out.println(" ");
		System.out.println("Tabuľka casov dokoncenia uloh na virtuálnych strojoch");
		for (int i = 0; i < all_vm_count; i++) {
			System.out.println("VM " + i);
			for (int j = 0; j < finish_time_list[i].size(); j++) {
				System.out.print(finish_time_list[i].get(j) + " ");
			}
			System.out.println();
		}


//		vypocet kompletneho casu cakania vsetkych strojov na dokoncenie poslednej ulohy
		System.out.println(" ");
		for (int i = 0; i < all_vm_count; i++) {
			double waiting_time = simulation_time - finish_time_list[i].get(1);
			complete_waiting_time = complete_waiting_time + waiting_time;
			complete_waiting_time = (Precision.round(complete_waiting_time, 2));
			waiting_time = (Precision.round(waiting_time, 2));
			System.out.println("Vm "+ i + " cakal  " + waiting_time +" sekund " );
			}


		avg_waiting_time = complete_waiting_time / all_vm_count;
		avg_waiting_time = Precision.round(avg_waiting_time,2);
		System.out.println(" ");
		System.out.println("Kompletny cas cakania je: " + complete_waiting_time + " sekund ");
		System.out.println("Priemerny cas cakania je: " + avg_waiting_time + " sekund");


//		zapis rovrhu do suboru
//		saveScheduleToFile(schedule_list);

	}

//	vynulovanie statickych premennych
	public static void restore_static_variables(){
		count_vm_0 = 0;
		count_vm_1 = 0;
		count_vm_2 = 0;
		count_vm_3 = 0;
		all_vm_count = 0;
		live_vm_mips = 0;
		all_vm_mips = 0;
		live_tasks_lengths = 0;
		all_tasks_lengths = 0;
		sum_tasks_lengths_0 = 0;
		sum_tasks_lengths_1 = 0;
		sum_tasks_lengths_2 = 0;
		sum_tasks_lengths_3 = 0;
		count_tasks_0 = 0;
		count_tasks_1 = 0;
		count_tasks_2 = 0;
		count_tasks_3 = 0;
		all_tasks_count = 0;
		completed_tasks = 0;
		failed_tasks = 0;
		percentage_of_failed_tasks = 0.0;
		prediction_accuracy = -1;
		complete_waiting_time = 0.0;
		avg_waiting_time = 0.0;
		percentage_of_successful_IoT_tasks = 0.0;
		successful_IoT_tasks = 0;
		failed_IoT_tasks = 0;
	}

	public static void saveScheduleToFile(ArrayList<Integer>[] schedule_list) throws FileNotFoundException {
		String fileName = simulation_time +"_tasks_"+ all_tasks_count+ ".txt";
		File outputFile = new File("outputTsTs/" + fileName);
		PrintWriter scheduleFIle = new PrintWriter(outputFile);

//		zapis do suboru
		for (int i = 0; i < all_vm_count; i++) {
			scheduleFIle.println("VM " + i);
			for (int j = 0; j < schedule_list[i].size(); j++) {
				scheduleFIle.print(schedule_list[i].get(j) + " ");
			}
			scheduleFIle.println();
		}
		scheduleFIle.close();

	}

	//	Citanie datasetu z txt suboru
	public static ArrayList<Long> readDatasetFromFile(String type_of_dataset) throws FileNotFoundException {
		File file = new File(type_of_dataset);
		Scanner scanner = new Scanner(file);
		ArrayList<Long> longs = new ArrayList<>();
		while (scanner.hasNext()) {
			if (scanner.hasNextLong()) {
				longs.add(scanner.nextLong());
			} else {
				scanner.next();
			}
		}

		return longs;
	}

	//	Citanie deadlinov datasetu z txt suboru
	public static ArrayList<Double> readDeadlineFromFile(String type_of_dataset) throws FileNotFoundException {
		File file = new File(type_of_dataset);
		Scanner scanner = new Scanner(file);
		ArrayList<Double> doubles = new ArrayList<>();
		while (scanner.hasNext()) {
			if (scanner.hasNextLine()) {
				doubles.add(Double.valueOf(scanner.nextLine()));
			} else {
				scanner.next();
			}
		}

		return doubles;
	}


}
