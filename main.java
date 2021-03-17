
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
  static final int RUNS_UP = 1;
  static final int RUNS_DN = -1;  
  
  public static void main(String[] pArgs)  {
    main mainObject = new main();
    
    main.runs();
  }
  private static void runs() {
    ArrayList<Integer> list = new ArrayList<>();
    try {
      readInputFile("p1-in.txt", list);
    }catch(FileNotFoundException pException){
      System.out.print("Oops, could not open'p1-in.txt' for reading. The program is ending.");
      System.exit(-100); 
    }
    
    ArrayList<Integer> listRunsUpCount = new ArrayList<>();
    ArrayList<Integer> listRunsDnCount = new ArrayList<>();
    findRuns(list,RUNS_UP);
    findRuns(list,RUNS_DN);
    ArrayList<Integer> listRunsCount = new ArrayList<>();
    mergeLists(listRunsUpCount, listRunsDnCount);
    
    try {
      writeOutputFile("p1-runs.txt", listRunsCount);
    }catch(FileNotFoundException pException){
      System.out.print("Oops, could not open 'p1-runs.txt' for writing. The program is ending.");
      System.exit(-200);
    }
  }
  
  private static ArrayList<Integer> findRuns(ArrayList<Integer> pList, int pDir){
    arrayListCreate(pList.size(),0);
    int i = 0;
    int k = 0;
    while(i<pList.size()-1){
      if(pDir == RUNS_UP && pList.get(i) <= pList.get(i+1)){
        k++;
      }else{
        //if k does not equal 0 then increment the element at index k of listRunsCount
      }
      i++;
    }
    if(k!=0){
      //increment the element at index k of listRunsCount
    }
    
	ArrayList<Integer> listRunsCount = null;
	return listRunsCount;
  }
  
  private static ArrayList<Integer> mergeLists(ArrayList<Integer> pListRunsUpCount, ArrayList<Integer> pListRunsDnCount){
    ArrayList<Integer> listRunsCount = new ArrayList(pListRunsUpCount.size());
    for(int i = 0; i<=pListRunsUpCount.size()-1;i++){
      listRunsCount.get(i);
      //Set element i of listRunsCount to the sum of the elements at i in pListRunsUpCount and pListRunsDnCount
    }
	return listRunsCount;
  }
  
  private static ArrayList<Integer> arrayListCreate(int pSize, int pInitValue){
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i<= pSize-1; i++){
      list.add(pInitValue);
    }
    return list;
  }
  
  private static void writeOutputFile(String pFilename, ArrayList<Integer> pListRuns)throws FileNotFoundException{
    PrintWriter out = new PrintWriter(new File(pFilename));
    out.printf("runs_total: ", "the-sum-of-",pListRuns);
    for(int k = 1; k <= pListRuns.size()-1; k++){
      System.out.print("runs_");
      System.out.print(k);
      System.out.println(" the element at index k of pListRuns");
    }
    out.close();
  }
  
  private static ArrayList<Integer> readInputFile(String pFilename, ArrayList<Integer> pListRuns) throws FileNotFoundException{
    Scanner in = new Scanner(new File(pFilename));
    ArrayList<Integer> list = new ArrayList<>();
    do{
      list.add(in.nextInt());
    }while(in.hasNext()==true);
    in.close();
    return list;
  }
  

}
