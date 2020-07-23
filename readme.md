下表列出了Spring数据存储库查询派生机制通常支持的关键字。但是，请参考特定于存储的文档以获得受支持关键字的确切列表，因为这里列出的一些关键字可能在特定的存储中不受支持。

Techniques adopted

tec                      |   official website 
-------------------------|-------------------
SPRING DATA JPA          |  https://spring.io/projects/spring-data
MAPSTRUCT                |  https://mapstruct.org/





Logical keyword          |        Keyword expressions
-------------------------|---------------------
AND                      |        And
OR                       |        Or
AFTER                    |        After, IsAfter
BEFORE                   |        Before, IsBefore
CONTAINING               |        Containing, IsContaining, Contains
BETWEEN                  |        Between, IsBetween
ENDING_WITH              |        EndingWith, IsEndingWith, EndsWith
EXISTS                   |        Exists
FALSE                    |        False, IsFalse
GREATER_THAN             |        GreaterThan, IsGreaterThan
GREATER_THAN_EQUALS      |        GreaterThanEqual, IsGreaterThanEqual
IN                       |        In, IsIn
IS                       |        Is, Equals, (or no keyword)
IS_EMPTY                 |        IsEmpty, Empty
IS_NOT_EMPTY             |        IsNotEmpty, NotEmpty
IS_NOT_NULL              |        NotNull, IsNotNull
IS_NULL                  |        Null, IsNull
LESS_THAN                |        LessThan, IsLessThan
LESS_THAN_EQUAL          |        LessThanEqual, IsLessThanEqual
LIKE                     |        Like, IsLike
NEAR                     |        Near, IsNear
NOT                      |        Not, IsNot
NOT_IN                   |        NotIn, IsNotIn
NOT_LIKE                 |        NotLike, IsNotLike
REGEX                    |        Regex, MatchesRegex, Matches
STARTING_WITH            |        StartingWith, IsStartingWith, StartsWith
TRUE                     |        True, IsTrue
WITHIN                   |        Within, IsWithin
