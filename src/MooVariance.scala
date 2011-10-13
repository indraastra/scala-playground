class Bovine
class Cow extends Bovine
class BrownCow extends Cow

// A trivial class to play around with the covariance and contravariance
// of Function1[-A, +A].
class VariantFunction1[-A, +B]

// This is the obvious use: Cow in, Cow out...the compiler is uncowed?
// However, now the type of the moo variable is set.
var moo = new VariantFunction1[Cow, Cow]
// This shows off the contravariant first parameter of VariantFunction1, since
// moo accepts Cows but is successfully reassigned to a function that accepts
// Bovines. In other words, Function1[Bovine, Cow] is a counterintuitive subtype
// of Function1[Cow, Cow] since the former can always stand in for the latter,
// even though Cow is a subtype of Bovine.
// It seems like a subtype relationship doesn't necessarily imply a subset
// relationship.
moo = new VariantFunction1[Bovine, Cow]
// This shows off the covariant second parameter of VariantFunction1, since moo
// returns Cows but is successfully reassigned to a function that returns
// BrownCows. In other words, Function1[Cow, BrownCow] is a subtype of
// Function1[Cow, Cow].
moo = new VariantFunction1[Cow, BrownCow]

// This shows what happens without the variance hints.
class NonvariantFunction1[A, B]
var badmoo = new NonvariantFunction1[Cow, Cow]
// moo = new NonvariantFunction1[Bovine, Cow]    // FAILS
// moo = new NonvariantFunction1[Cow, BrownCow]  // FAILS