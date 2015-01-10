# StringConverter
API which helps you to convert 
String to standard list 
of java types:

byte/Byte
boolean/Boolean
char/Charachter
short/Short
float/Float
long/Long
double/Double
int/Integer

String
BigInteger/BigDecimal
UUID

Also library contains cache with replacable transformers.


Use:

StringTransformManagerImpl.getInstance().getTransformer(Integer.class).transform("123")

Or

StringTransformManagerImpl.getInstance()

void register(StringTransformer<?> stringTransformer);
void unregister(StringTransformer<?> stringTransformer);

for update/replace transformers
