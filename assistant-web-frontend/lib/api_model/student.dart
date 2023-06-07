import 'user.dart';

class Student extends User {
  Student({super.id, required super.email, super.password,
    required this.firstname, required this.lastname, required this.idClass});
  final String firstname;
  final String lastname;
  final int idClass;
}