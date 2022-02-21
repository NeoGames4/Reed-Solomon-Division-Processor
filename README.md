# Reed-Solomon-Division-Processor
Decent Java classes for calculating the remainders of a polynomial division in a GF(256) for a Reed Solomon code (for example).<br><br>
Note: **Everything is only barely documented, so reading https://www.thonky.com/qr-code-tutorial/error-correction-coding before using is highly being recommended.**

## How To Use
Suppose you have two polynomials:<br>
A generator polynomial like<br>2^0x^n + 2^251x^(n-1) + 2^67x^(n-2) + 2^46x^(n-3) + 2^61x^(n-4) + 2^118x^(n-5) + 2^70x^(n-6) + 2^64x^(n-7) + 2^94x^(n-8) + 2^32x^(n-9) + 2^45x^(n-10)<br>
and a message polynomial like<br>32x^n + 91x^(n-1) + 11x^(n-2) + 120x^(n-3) + 209x^(n-4) + 114x^(n-5) + 220x^(n-6) + 77x^(n-7) + 67x^(n-8) + 64x^(n-9) + 236x^(n-10) + 17x^(n-11) + 236x^(n-12) + 17x^(n-13) + 236x^(n-14) + 17x^(n-15)<br>
(as in https://www.thonky.com/qr-code-tutorial/error-correction-coding) (the exponents of x are not relevant)<br>
...then the DivisionProcessor class could be used for dividing the generator polynomial by the message polynomial in order to get the final error correction polynomial simply by executing the `new DivisionProcessor(generatorPolynom, messagePolynom).getRemainders()`-method. (The method expects you to enter the polynomials – as explained in the following section – in alpha notation!)

## Polynomial Formatting
As already mentioned, the exponents of x should not be relevant. Therefore, you can leave them out, as well as the 'x' of the last summand. Further, in alpha notation you only need to write the exponents of alpha, instead of the whole power. Also you should leave out the plus sign and the spaces.<br><br>
For example;<br>
`2^0x^n + 2^251x^(n-1) + 2^67x^(n-2) + 2^46x^(n-3) + 2^61x^(n-4) + 2^118x^(n-5) + 2^70x^(n-6) + 2^64x^(n-7) + 2^94x^(n-8) + 2^32x^(n-9) + 2^45x^(n-10)`<br>
becomes<br>
`0x251x67x46x61x118x70x64x94x32x45`<br><br>
While the message polynomial from above becomes<br>
`32x91x11x120x209x114x220x77x67x64x236x17x236x17x236x17`<br>
Note that the first example was written in alpha notation and the second one in integer notation. The DivisionProcessor expects you to enter every polynomial in alpha notation. To convert them, use `AlphaNotation.toAlphaNotation(integerNotation)` and enter the polynomial as shown above.
