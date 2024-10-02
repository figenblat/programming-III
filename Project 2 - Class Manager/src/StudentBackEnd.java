import java.util.List;

// interface (implemented with proposal)

interface StudentBackEndInterface {    
    public void addStudent(SortedCollectionInterface student);
    public boolean containsStudent(SortedCollectionInterface student);

    // returns list of the titles of all songs that contain the word titleWord in their song title
    public List<String> findGPA(String titleWord);

    // returns list of the artists of all songs that contain the word titleWord in their song title
    public List<String> findName(String titleWord);

    // returns the number of songs that contain the word titleWord in their song title, and were published in year
    public int findStudentID(String titleWord, int year);
}

// public class (implemented primarilly in final app week)

public class StudentBackEnd implements SortedCollectionInterface {
	RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
    @Override
    public void addStudent(SortedCollectionInterface student) {
        tree.insert(SortedCollectionInterface student);
        
    }

    @Override
    public boolean containsStudent(SortedInterface student) {
        if (student == null){
		return false;
	}
        tree.contains(SortedInterface student);
    }

    @Override
    public List<Double> findGPAs(String ID) {
	StudentDataInterface student = new StudentDataInterface();
	Node<T> start = new Node<T> (root); 
        if (tree.root == ID){
		return tree.root.getGPA();
	}
	for (int i =0;i<tree.size();i++){
		if (tree.getID == ID){
			start = tree.getID;
		}
		 else if (tree.getleftChild.getID() == ID){
                        start = tree.getID; //gets node of the ID
	}
	}
        return start.getGPA;
    
     @Override
    public List<String> findGrade(String ID) {
	    StudentDataInterface student = new StudentDataInterface();
          Node<T> start = new Node<T> (root);
        if (tree.root == ID){
                return tree.root.getGPA();
        }
        for (int i =0;i<tree.size();i++){
                if (tree.getID == student.getID){
                        start = tree.getID; //gets the node of the ID
                }
		 else if (tree.getleftChild.getID() == student.getID){
                        start = tree.getID; //gets node of the ID
        }
	}
        return start.getGrade; //returns the Grade of the given node
    
    }

    @Override
    public List<String> findNames(String ID) {
          StudentDataInterface student = new StudentDataInterface();
          Node<T> start = new Node<T> (root);
        if (tree.root == ID){
                return tree.root.getName();
        }
        for (int i =0;i<tree.size();i++){
                if (tree.getrightChild.getID() == ID){
                        start = tree.getID; //gets node of the ID
                }
		else if (tree.getleftChild.getID() == ID){
			start = tree.getID; //gets node of the ID
        }
	}
        return student.getName; //returns the name at the given node
    
    }
    
    @Override
    public int findStudentID() {
         StudentDataInterface student = new StudentDataInterface();
          Node<T> start = new Node<T> (root);
        if (tree.root == ID){
                return tree.root();
        }
        for (int i =0;i<tree.size();i++){
                if (tree.getID == ID){
                        start = tree.getID; //gets the node of the ID
                }
                 else if (tree.getleftChild.getID() == ID){
                        start = tree.getID; //gets node of the ID
        }
	}
        return start.getID; //returns the Grade of the given node
    
    }
   
   @Override
    public List<String> findBirthdays(String ID) {
        StudentDataInterface student = new StudentDataInterface();
          Node<T> start = new Node<T> (root);
        if (tree.root == ID){
                return tree.root.getBirthday();
        }
        for (int i =0;i<tree.size();i++){
                if (tree.getrightChild.getID() == ID){
                        start = tree.getID; //gets node of the ID
                }
                else if (tree.getleftChild.getID() == ID){
                        start = tree.getID; //gets node of the ID
        }
        }
        return student.getBirthday; //returns the name at the given node
    }
    
interface StuentBackEndInterface {
  public void addStudent(StudentDataInterface song);

  public boolean containsSong(StudentDataInterface song);

  public List<String> findGPAs(String ID);

  public List<String> findGrades(String ID);

  public List<String> findNames(String ID);

  public List<String> findBirthdays(String ID);

  public int findStudentID();
}
}
