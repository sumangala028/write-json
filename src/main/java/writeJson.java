




import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class writeJson {

    public static void main(String[] args) {
        CommentLines cmtLine1 = new CommentLines();
        cmtLine1.insertCommentLines(1);
        cmtLine1.insertCommentLines(2);
        cmtLine1.insertCommentLines(3);

        CommentLines cmtLine2 = new CommentLines();
        cmtLine2.insertCommentLines(16);
        cmtLine2.insertCommentLines(7);
        cmtLine2.insertCommentLines(8);

        CommentLines cmtLine3 = new CommentLines();
        cmtLine3.insertCommentLines(12);
        cmtLine3.insertCommentLines(13);
        cmtLine3.insertCommentLines(14);

        BalSample sample = new BalSample("test_1.bal", "<sample_code>");
        sample.addComments(cmtLine1);
        sample.addComments(cmtLine2);
        sample.addComments(cmtLine3);

        ObjectMapper mapper = new ObjectMapper();
        try {
            // Java objects to JSON file
            mapper.writeValue(new File("/home/jayasumanagala/ballerina_repo/ballerina-lang/examples/hello-world/test_1.bal"), sample);
            System.out.println("Finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Bal Object Modal Class
class BalSample {
    String name;
    String source;
    ArrayList<HashMap<String, CommentLines>> comments;

    BalSample(String name, String source) {
        this.name = name;
        this.source = source;
        this.comments = new ArrayList<HashMap<String, CommentLines>>();
    }

    public void addComments(CommentLines lines) {
        HashMap<String, CommentLines> hashMap = new HashMap<String, CommentLines>();
        hashMap.put("lines",lines);
        comments.add(hashMap);
    }
}

// Comment Lines Object Modal Class
class CommentLines {
    ArrayList<Integer> lines;

    CommentLines() {
        lines = new ArrayList<Integer>();
    }

    public void insertCommentLines(int val) {
        lines.add(val);
    }

    public ArrayList<Integer> getLines() {
        return lines;
    }
}