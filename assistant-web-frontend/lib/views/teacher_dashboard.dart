import 'package:flutter/material.dart';

import '../api_model/teacher.dart';
import '../component/teacher_dashboard/header.dart';
import '../component/teacher_dashboard/history_table.dart';
import '../component/teacher_dashboard/homework_progress_chart.dart';
import '../component/teacher_dashboard/info_card.dart';
import '../component/teacher_dashboard/navbar_action_items.dart';
import '../component/teacher_dashboard/side_menu.dart';
import '../component/teacher_dashboard/student_performance_details.dart';
import '../config/responsive.dart';
import '../config/size_config.dart';
import '../style/palette.dart';
import '../style/primary_text.dart';
import 'students_list.dart';

class TeacherDashboard extends StatelessWidget {
  TeacherDashboard({super.key, required this.teacher});

  final GlobalKey<ScaffoldState> _drawerKey = GlobalKey();
  final Teacher teacher;

  @override
  Widget build(BuildContext context) {
    SizeConfig().init(context);
    return Scaffold(
      key: _drawerKey,
      drawer: const SizedBox(width: 100, child: SideMenu()),
      appBar: !Responsive.isDesktop(context)
          ? AppBar(
              elevation: 0,
              backgroundColor: Palette.whiteColor,
              leading: IconButton(
                  onPressed: () {
                    _drawerKey.currentState?.openDrawer();
                  },
                  icon: const Icon(Icons.menu, color: Palette.backgroundColor)),
              actions: const <NavBarActionItems>[
                NavBarActionItems(),
              ],
            )
          : const PreferredSize(
              preferredSize: Size.zero,
              child: SizedBox(),
            ),
      body: SafeArea(
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            if (Responsive.isDesktop(context))
              const Expanded(
                child: SideMenu(),
              ),
            Expanded(
                flex: 10,
                child: SafeArea(
                  child: SingleChildScrollView(
                    padding: const EdgeInsets.symmetric(vertical: 30, horizontal: 30),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        const Header(title: 'Clasa IX B',),
                        SizedBox(
                          height: SizeConfig.blockSizeVertical * 4,
                        ),
                        SizedBox(
                          width: SizeConfig.screenWidth,
                          child: Wrap(
                            spacing: 20,
                            runSpacing: 20,
                            alignment: WrapAlignment.spaceBetween,
                            children: <Widget>[
                              GestureDetector(
                                onTap: () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute<StudentsList>(
                                        builder: (BuildContext context) => StudentsList(classId: 1)),
                                  );
                                },
                                child: InfoCard(icon: 'assets/credit-card.svg', label: 'Gestiune clasă', amount: r'>'),
                              ),
                              InfoCard(icon: 'assets/transfer.svg', label: 'Modifică teme', amount: r'>'),
                              InfoCard(icon: 'assets/bank.svg', label: 'Adaugă teme', amount: r'>'),
                              InfoCard(icon: 'assets/invoice.svg', label: 'Export statistici', amount: '>'),
                            ],
                          ),
                        ),
                        const SizedBox(
                          height: 30,
                        ),
                        const Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: <Widget>[
                            Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: <PrimaryText>[
                                PrimaryText(
                                  text: '',
                                  size: 16,
                                  color: Palette.secondary,
                                ),
                                PrimaryText(text: 'Progres teme', size: 30, fontWeight: FontWeight.w800),
                              ],
                            ),
                            PrimaryText(
                              text: '',
                              size: 16,
                              color: Palette.secondary,
                            ),
                          ],
                        ),
                        SizedBox(
                          height: SizeConfig.blockSizeVertical * 3,
                        ),
                        const SizedBox(
                          height: 180,
                          child: HomeworkProgressChart(),
                        ),
                        SizedBox(
                          height: SizeConfig.blockSizeVertical * 5,
                        ),
                        const Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: <PrimaryText>[
                            PrimaryText(text: 'Activități recente', size: 30, fontWeight: FontWeight.w800),
                            PrimaryText(
                              text: '',
                              size: 16,
                              color: Palette.secondary,
                            ),
                          ],
                        ),
                        SizedBox(
                          height: SizeConfig.blockSizeVertical * 3,
                        ),
                        const HistoryTable(),
                        if (!Responsive.isDesktop(context)) const StudentPerformanceDetails()
                      ],
                    ),
                  ),
                )),
            if (Responsive.isDesktop(context))
              Expanded(
                flex: 4,
                child: SafeArea(
                  child: Container(
                    width: double.infinity,
                    height: SizeConfig.screenHeight,
                    decoration: const BoxDecoration(color: Palette.gradient1),
                    child: const SingleChildScrollView(
                      padding: EdgeInsets.symmetric(vertical: 30, horizontal: 30),
                      child: Column(
                        children: <Widget>[
                          NavBarActionItems(),
                          StudentPerformanceDetails(),
                        ],
                      ),
                    ),
                  ),
                ),
              ),
          ],
        ),
      ),
    );
  }
}
