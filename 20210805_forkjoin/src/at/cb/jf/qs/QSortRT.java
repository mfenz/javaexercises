package at.cb.jf.qs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class QSortRT extends RecursiveTask<List<Integer>> {

    private List<Integer> field;

    public QSortRT(List<Integer> field) {
        this.field = field;
    }

    @Override
    protected List<Integer> compute() {
        if(field.size() <= 1){
            return field;
        }
        // Wähle Pivot
        int pivot = field.get(0);

        // Left
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i = 1; i < field.size(); i++){
            int x = field.get(i);
            if(x < pivot){
                left.add(x);
            } else {
                right.add(x);
            }
        }

        // Gehe durch field und ordner in left/right ein
//        for(int x : field){
//            if(x < pivot){
//                left.add(x);
//            } else {
//                right.add(x);
//            }
//        }

        QSortRT leftTask = new QSortRT(left);
        leftTask.fork();

        QSortRT rightTask = new QSortRT(right);
        List<Integer> rightResult = rightTask.compute();
        List<Integer> leftResult = leftTask.join();

        leftResult.add(pivot);
        leftResult.addAll(rightResult);
        return leftResult;
    }
}
