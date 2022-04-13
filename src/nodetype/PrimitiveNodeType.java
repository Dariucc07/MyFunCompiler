package nodetype;

public enum PrimitiveNodeType implements NodeType {

    BOOL {
        @Override
        public PrimitiveNodeType checkAdd(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkSub(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkMul(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkDiv(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkRel(PrimitiveNodeType type) {
            switch(type){
                case BOOL:
                    return BOOL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkDivInt(PrimitiveNodeType type) {
            return null;
        }

        @Override
        public PrimitiveNodeType checkPow(PrimitiveNodeType type) {
            return null;
        }

        @Override
        public PrimitiveNodeType checkStrConcat(PrimitiveNodeType type) {
            switch(type) {
                case STRING: case INT: case REAL: case BOOL:
                    return STRING;

                default:
                    return NULL;
            }
        }
        @Override
        public PrimitiveNodeType checkOpType(PrimitiveNodeType type) {
            switch(type){
                case BOOL:
                    return BOOL;
                default:
                    return NULL;
            }
        }
    },

    REAL {
        @Override
        public PrimitiveNodeType checkAdd(PrimitiveNodeType type) {
            switch(type){
                case INT: case REAL:
                    return REAL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkOpType(PrimitiveNodeType type) {
            switch(type){
                case INT: case REAL:
                    return REAL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkSub(PrimitiveNodeType type) {
            switch(type){
                case INT: case REAL:
                    return REAL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkMul(PrimitiveNodeType type) {
            switch(type){
                case INT: case REAL:
                    return REAL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkDiv(PrimitiveNodeType type) {
            switch(type) {
                case INT: case REAL:
                    return REAL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkRel(PrimitiveNodeType type) {
            switch(type){
                case INT: case REAL:
                    return BOOL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkDivInt(PrimitiveNodeType type) {
            return null;
        }

        @Override
        public PrimitiveNodeType checkPow(PrimitiveNodeType type) {
            switch(type){
                case INT: case REAL:
                    return REAL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkStrConcat(PrimitiveNodeType type) {
            switch(type) {
                case STRING: case INT: case REAL: case BOOL:
                    return STRING;

                default:
                    return NULL;
            }
        }

    },

    INT {


        @Override
        public PrimitiveNodeType checkAdd(PrimitiveNodeType type) {
            switch(type) {
                case INT:
                    return INT;
                case REAL:
                    return REAL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkSub(PrimitiveNodeType type) {
            switch(type) {
                case INT:
                    return INT;
                case REAL:
                    return REAL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkMul(PrimitiveNodeType type) {
            switch(type){
                case INT:
                    return INT;
                case REAL:
                    return REAL;
                default:
                    return NULL;
            }
        }


        @Override
        public PrimitiveNodeType checkDiv(PrimitiveNodeType type) {
            switch(type){
                case INT:
                    return INT;
                case REAL:
                    return REAL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkRel(PrimitiveNodeType type) {
            switch(type) {
                case INT: case REAL:
                    return BOOL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkDivInt(PrimitiveNodeType type) {
            switch(type) {
                case INT:
                    return INT;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkPow(PrimitiveNodeType type) {
            switch(type) {
                case INT:
                    return INT;
                case REAL:
                    return REAL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkStrConcat(PrimitiveNodeType type) {
            switch(type) {
                case STRING: case INT: case REAL: case BOOL:
                    return STRING;

                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkOpType(PrimitiveNodeType type) {
            switch(type) {
                case INT: case REAL:
                    return INT;
                default:
                    return NULL;
            }
        }
    },

    NULL {
        @Override
        public PrimitiveNodeType checkAdd(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkSub(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkMul(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkDiv(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkRel(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkDivInt(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkPow(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkStrConcat(PrimitiveNodeType type) {
            switch(type) {
                case STRING: case INT: case REAL: case BOOL:
                    return STRING;

                default:
                    return NULL;
            }
        }
        @Override
        public PrimitiveNodeType checkOpType(PrimitiveNodeType type) {
            return NULL;
        }
    },

    STRING {
        @Override
        public PrimitiveNodeType checkAdd(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkSub(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkMul(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkDiv(PrimitiveNodeType type) {
            return NULL;
        }

        @Override
        public PrimitiveNodeType checkRel(PrimitiveNodeType type) {
            switch(type){
                case STRING:
                    return BOOL;
                default:
                    return NULL;
            }
        }

        @Override
        public PrimitiveNodeType checkDivInt(PrimitiveNodeType type) {
            return null;
        }

        @Override
        public PrimitiveNodeType checkPow(PrimitiveNodeType type) {
            return null;
        }

        @Override
        public PrimitiveNodeType checkStrConcat(PrimitiveNodeType type) {
            switch(type) {
                case STRING: case INT: case REAL: case BOOL:
                    return STRING;

                default:
                    return NULL;
            }
        }
        @Override
        public PrimitiveNodeType checkOpType(PrimitiveNodeType type) {
            switch(type){
                case STRING:
                    return STRING;
                default:
                    return NULL;
            }
        }
    };
// c relative code for primitive types
    public String cType(){
        switch(this){
            case STRING:
                return "char *";
            case REAL:
                return "float";
            case BOOL:
                return "int";
            case INT:
                return "int";
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        switch(this){
            case BOOL:
                return "bool";
            case INT:
                return "integer";
            case REAL:
                return "real";
            case STRING:
                return "string";
            default:
                return "null";
        }
    }
}