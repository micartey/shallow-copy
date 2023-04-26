import me.micartey.shallowcopy.Expose;
import me.micartey.shallowcopy.ShallowCopy;
import org.junit.jupiter.api.Test;

public class ShallowCopyTest {

    @Test
    public void testShallowCopy() {
        TestParent parent = new TestParent();
        parent.field = 5;

        TestParent copy = new ShallowCopy<>(TestParent.class).copy(parent, new TestParent());
        assert copy.field == parent.field;
    }

    public class TestParent {
        @Expose
        public int field;
    }
}
