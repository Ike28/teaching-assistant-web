import 'package:flutter/material.dart';

import 'pallete.dart';
import 'widgets/gradient_button.dart';
import 'widgets/login_field.dart';
import 'widgets/social_button.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ColoredBox(
        color: Palette.backgroundColor,
        child: SingleChildScrollView(
          child: Center(
            child: Column(
              children: <Widget>[
                Image.asset('assets/img/sign_in.png'),
                const Text(
                  'Bun venit',
                  style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 50,
                    color: Palette.whiteColor
                  ),
                ),
                const SizedBox(height: 50),
                const SocialButton(iconPath: 'assets/svg/g_logo.svg', label: 'Continuă cu GitHub'),
                const SizedBox(height: 20),
                const SocialButton(
                  iconPath: 'assets/svg/f_logo.svg',
                  label: 'Continuă cu Google',
                  horizontalPadding: 90,
                ),
                const SizedBox(height: 15),
                const Text(
                  'sau',
                  style: TextStyle(
                    fontSize: 17,
                  ),
                ),
                const SizedBox(height: 15),
                const LoginField(hintText: 'Email', obscure: false),
                const SizedBox(height: 15),
                const LoginField(hintText: 'Parolă', obscure: true),
                const SizedBox(height: 20),
                const GradientButton(),
                const SizedBox(height: 100)
              ],
            ),
          ),
        ),
      ),
    );
  }
}