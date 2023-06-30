package playground;

import kr.co.sample.enums.TempFunctionEnum;

public class Playground {
    public static void main(String[] args) {
        System.out.println(TempFunctionEnum.TEMP_FUNCTION_1.apply("예시"));

        var str = "문자열";

        arrowSwitchWithoutResult(str);
        arrowSwitchWithResult(str);
        System.out.println(arrowSwitchWithResultReturn(str));
    }

    public static void arrowSwitchWithoutResult(String name) {
        switch (name) {
            case "kim" -> System.out.println("name : kim");
            case "lee" -> System.out.println("name : lee");
            case "jerry" -> {
                System.out.println("before yield");
                // yield 0;  // 리턴 받지 않는 경우는 yield 사용하지 않
            }
            default -> System.out.println("not fount");
        }
    }

    public static void arrowSwitchWithResult(String name) {
        String result = switch (name) {
            case "kim" -> "called kim";
            case "lee" -> "called lee";
            case "jerry" -> {
                System.out.println("before yield jerry");
                yield "jerry";
            }
            case "lucy" -> {
                System.out.println("before yield lucy");
                yield "lucy";
                //  System.out.println("after yield lucy"); // unreachable statement. yield 이후에 statement가 있으면 컴파일 오류
            }
            default -> "not found";
        };
        System.out.println("result : " + result);
    }

    public static String arrowSwitchWithResultReturn(String name) {
        return switch (name) {
            case "kim" -> "called kim";
            case "lee" -> "called lee";
            case "jerry" -> {
                System.out.println("before yield jerry");
                yield "jerry";
            }
            case "lucy" -> {
                System.out.println("before yield lucy");
                yield "lucy";
                //  System.out.println("after yield lucy"); // unreachable statement. yield 이후에 statement가 있으면 컴파일 오류
            }
            default -> "not found";
        };
    }
}
