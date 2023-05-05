import 'package:flutter/material.dart';

import 'component/appBarActionItems.dart';
import 'component/barChart.dart';
import 'component/header.dart';
import 'component/historyTable.dart';
import 'component/infoCard.dart';
import 'component/paymentDetailList.dart';
import 'component/sideMenu.dart';
import 'config/responsive.dart';
import 'config/size_config.dart';
import 'pallete.dart';
import 'style/style.dart';

class Dashboard extends StatelessWidget {
  Dashboard({super.key});

  final GlobalKey<ScaffoldState> _drawerKey = GlobalKey();

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
              actions: const [
                AppBarActionItems(),
              ],
            )
          : const PreferredSize(
              preferredSize: Size.zero,
              child: SizedBox(),
            ),
      body: SafeArea(
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            if (Responsive.isDesktop(context))
              const Expanded(
                flex: 1,
                child: SideMenu(),
              ),
            Expanded(
                flex: 10,
                child: SafeArea(
                  child: SingleChildScrollView(
                    padding: EdgeInsets.symmetric(vertical: 30, horizontal: 30),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Header(),
                        SizedBox(
                          height: SizeConfig.blockSizeVertical * 4,
                        ),
                        SizedBox(
                          width: SizeConfig.screenWidth,
                          child: Wrap(
                            spacing: 20,
                            runSpacing: 20,
                            alignment: WrapAlignment.spaceBetween,
                            children: const [
                              InfoCard(
                                  icon: 'assets/credit-card.svg',
                                  label: 'Gestiune clasă',
                                  amount: r'>'),
                              InfoCard(
                                  icon: 'assets/transfer.svg',
                                  label: 'Modifică teme',
                                  amount: r'>'),
                              InfoCard(
                                  icon: 'assets/bank.svg',
                                  label: 'Adaugă teme',
                                  amount: r'>'),
                              InfoCard(
                                  icon: 'assets/invoice.svg',
                                  label: 'Export statistici',
                                  amount: '>'),
                            ],
                          ),
                        ),
                        SizedBox(
                          height: SizeConfig.blockSizeVertical * 4,
                        ),
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          crossAxisAlignment: CrossAxisAlignment.center,
                          children: [
                            Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: const [
                                PrimaryText(
                                  text: '',
                                  size: 16,
                                  fontWeight: FontWeight.w400,
                                  color: Palette.secondary,
                                ),
                                PrimaryText(
                                    text: 'Progres teme',
                                    size: 30,
                                    fontWeight: FontWeight.w800),
                              ],
                            ),
                            const PrimaryText(
                              text: '',
                              size: 16,
                              color: Palette.secondary,
                            ),
                          ],
                        ),
                        SizedBox(
                          height: SizeConfig.blockSizeVertical * 3,
                        ),
                        Container(
                          height: 180,
                          child: BarChartCopmponent(),
                        ),
                        SizedBox(
                          height: SizeConfig.blockSizeVertical * 5,
                        ),
                        Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: const [
                            PrimaryText(
                                text: 'Activități recente',
                                size: 30,
                                fontWeight: FontWeight.w800),
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
                        if (!Responsive.isDesktop(context)) const PaymentDetailList()
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
                    child: SingleChildScrollView(
                      padding:
                          const EdgeInsets.symmetric(vertical: 30, horizontal: 30),
                      child: Column(
                        children: const [
                          AppBarActionItems(),
                          PaymentDetailList(),
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
