package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();

        // 正の数同士の足し算
        assertEquals(5, calculator.add(2, 3), "2 + 3 は 5 になるはず");

        // 負の数を含む足し算
        assertEquals(4, calculator.add(-1, 5), "-1 + 5 は 4 になるはず");

        // ゼロを含む足し算
        assertEquals(4, calculator.add(0, 4), "0 + 4 は 4 になるはず");
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();

        // 正の数同士の引き算
        assertEquals(2, calculator.subtract(5, 3), "5 - 3 は 2 になるはず");

        // 負の数を含む引き算
        assertEquals(-3, calculator.subtract(-1, 2), "-1 - 2 は -3 になるはず");

        // ゼロを含む引き算
        assertEquals(4, calculator.subtract(4, 0), "4 - 0 は 4 になるはず");
    }
}