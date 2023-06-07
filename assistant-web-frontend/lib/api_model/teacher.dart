import 'user.dart';

class Teacher extends User {
  Teacher({super.id, required super.email, super.password, required this.firstname, required this.lastname});

  final String firstname;
  final String lastname;
}
