package com.aibibang.pattern.builder;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description
 */
public class Bean {
    private String a;
    private String b;
    private String c;
    private String d;

    private Bean(Builder builder) {
        a = builder.a;
        b = builder.b;
        c = builder.c;
        d = builder.d;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    static class Builder {
        private String a;
        private String b;
        private String c;
        private String d;

        public Builder a(String a) {
            this.a = a;
            return this;
        }

        public Builder b(String b) {
            this.b = b;
            return this;
        }

        public Builder c(String c) {
            this.c = c;
            return this;
        }

        public Builder d(String d) {
            this.d = d;
            return this;
        }

        public Bean build() {
            return new Bean(this);
        }
    }
}
