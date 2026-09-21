package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DividerTest {

    @Test
    void testNormalDivision() {

        Divider divider = new Divider();

        // 正の数同士の除算
        assertEquals(
            3.0,
            divider.divide(6.0, 2.0),
            0.0001,
            "6 ÷ 2 は 3 になるはず"
        );

        // 負の数を含む除算
        assertEquals(
            -4.0,
            divider.divide(-8.0, 2.0),
            0.0001,
            "-8 ÷ 2 は -4 になるはず"
        );

        // 小数を含む除算
        assertEquals(
            2.5,
            divider.divide(5.0, 2.0),
            0.0001,
            "5.0 ÷ 2.0 は 2.5 になるはず"
        );
    }

    @Test
    void testExceptionDivision() {

        Divider divider = new Divider();

        // ゼロによる除算で例外が発生することを確認
        IllegalArgumentException e = assertThrows(
            IllegalArgumentException.class,
            () -> divider.divide(5.0, 0.0),
            "ゼロ除算で例外が発生するはず"
        );

        // 例外メッセージが正しいことを確認
        assertEquals(
            "ゼロで除算はできません",
            e.getMessage(),
            "例外メッセージが正しくない"
        );
    }
}