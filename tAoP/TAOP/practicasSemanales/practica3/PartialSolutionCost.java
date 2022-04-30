import java.util.List;

interface PartialSolutionCost extends Comparable {

    // if a state is not valid it should not be further
    // explored and can be discarded
    public boolean isValid();

    // if a state is valid and final then it is
    // considered a solution
    public boolean isFinal();

    // states which are valid but not final
    // must be further developed in order to
    // find a solution
    public List<PartialSolutionCost> successors();

}