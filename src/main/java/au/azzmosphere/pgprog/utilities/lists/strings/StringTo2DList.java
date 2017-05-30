package au.azzmosphere.pgprog.utilities.lists.strings;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron.spiteri on 26/5/17.
 */
public class StringTo2DList<Y> {
    private StringToList<Y> stringToList = new StringToList<>();

    public List<List<Y>> create2DList(String s, Class wrapperClass) throws Exception {
        String[] rows = s.split("\n");
        List<List<Y>> matrix = new ArrayList<>();

        for (String row : rows) {
            List k = stringToList.createList(row, wrapperClass);
            matrix.add(k);
        }

        return matrix;
    }
}
