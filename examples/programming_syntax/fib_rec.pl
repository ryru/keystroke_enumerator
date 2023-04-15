sub recFibN {
    my $n = shift;
    $n < 2 ? $n : fibRec($n - 1) + fibRec($n - 2);
}
