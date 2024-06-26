import java.util.Scanner;

class BST{
    private Integer value;
    private  BST left;
    private BST right;

    BST(Integer val){
        this.value = val;
    }

    void Insert(Integer value,BST current){

        // For root node
        if(current.value==null){ 
            current.value = value;
            return;
        } 

        // Insertion at right

        if(value>current.value && current.right==null){
            current.right = new BST(value);
        }else if(value>current.value && current.right!=null){
            Insert(value, current.right);
        }

        // Insertion at left

        if(value<=current.value && current.left==null){
            current.left = new BST(value);
            // return ;
        }else if(value<=current.value && current.left!=null){
            Insert(value, current.left);
        }
        // return;        
    }

    // Pre order traversal

    void traverseOrder(StringBuilder sb,String padding,String pointer,BST node,int depth){        
        if(node!=null){
            sb.append(padding);
            if(padding.equals("(root)")){
                padding = "";
            }
            sb.append(pointer);
            sb.append(node.value);
            sb.append("\n");
            StringBuilder paddingBuilder = new StringBuilder(padding);
            // paddingBuilder.append("\t".repeat(depth-1));
            paddingBuilder.append("|\t");

            String paddingForBoth = paddingBuilder.toString();
            // String tab = "\t";
            String pointerForRight = "└── (r)";
            String pointerForLeft = (node.right != null) ? "├── (l)" : "└── (l)";


            traverseOrder(sb, paddingForBoth, pointerForLeft ,node.left,depth+1);
            traverseOrder(sb, paddingForBoth, pointerForRight, node.right,depth+1);
        }
    }

    void print(){
        StringBuilder sb = new StringBuilder();
        traverseOrder(sb, "(root)", "", this,1); 
        System.out.println("\n"+sb.toString());
    }

}


class bt_vis{
    public static void main(String[] args) {
        // BST b = new BST(5);
        Scanner sc = new Scanner(System.in);
        
        BST root = new BST(null);

        while(true){      
            System.out.println("\n1)Enter a number to insert");
            System.out.println("2)Enter -1 to exit.");            
            // BST root = new BST(null);
            int val = sc.nextInt();            
            root.Insert(val, root);
            if(val==-1) break;
            System.out.println("Inserted\n");
            root.print();
        }
        System.out.println("\nSee you soon :-)");
        sc.close();
    }
}